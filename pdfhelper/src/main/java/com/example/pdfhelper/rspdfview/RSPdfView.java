package com.example.pdfhelper.rspdfview;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.pdfhelper.R;
import com.example.pdfhelper.pdfview.PdfView;
import com.example.pdfhelper.pdfview.download.DownloadService;
import com.example.pdfhelper.pdfview.utils.FileUtils;
import com.example.pdfhelper.pdfview.widget.AbsControllerBar;
import com.example.pdfhelper.rspdfview.adapter.RSPdfPageAdapter;
import com.example.pdfhelper.rspdfview.download.RSDownloadResultBroadcast;
import com.example.pdfhelper.rspdfview.download.RSDownloadService;
import com.example.pdfhelper.rspdfview.interfaces.IDownloadCallback;
import com.example.pdfhelper.rspdfview.interfaces.IPDFControl;
import com.example.pdfhelper.rspdfview.interfaces.IPDFOperateListener;
import com.example.pdfhelper.rspdfview.interfaces.IPageChangedListener;
import com.example.pdfhelper.rspdfview.layoutmanager.RSPageLayoutManager;
import com.example.pdfhelper.rspdfview.widget.RSAbsControllerBar;
import com.example.pdfhelper.rspdfview.widget.RSPdfLoadingLayout;
import com.example.pdfhelper.rspdfview.widget.RsScrollSlider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static com.example.pdfhelper.pdfview.download.DownloadService.DOWNLOAD_URL_KEY;
import static com.example.pdfhelper.rspdfview.constants.Constants.DOWNLOAD_ACTION;

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 * <p>
 * RSPdfView
 *
 * @author liujianming
 * @date 2022-07-20
 */
public class RSPdfView extends FrameLayout implements IDownloadCallback, IPDFOperateListener {

    private ViewGroup rootView;
    private FrameLayout controllerContainer;
    private RecyclerView contentRv;
    private RSPdfLoadingLayout loadingLayout;
    private RsScrollSlider scrollSlider;

    private int pageCount;

    private int currentIndex;

    private int quality;

    private String pdfLocalPath;
    private String pdfUrl;

    private List<Bitmap> pageList;

    private PdfRenderer pdfRenderer;
    private PdfRenderer.Page curPdfPage;
    private ParcelFileDescriptor parcelFileDescriptor;

    private RSPdfPageAdapter pageAdapter;
    private RSPageLayoutManager pageLayoutManager;
    private Intent serviceIntent;
    private RenderTask renderTask;

    private boolean hasRenderFinish;

    public RSPdfView(@NonNull Context context) {
        this(context, null);
    }

    public RSPdfView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RSPdfView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        handleStyleable(context, attrs);
        init();
    }

    private void handleStyleable(Context context, AttributeSet attrs) {
        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.PdfView, 0, 0);
        try {
            quality = ta.getInteger(R.styleable.PdfView_quality, 3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ta.recycle();
        }
    }

    private void init() {
        registerResultBroadcast();

        LayoutInflater.from(getContext()).inflate(R.layout.rs_layout_pdf_view, this);
        rootView = findViewById(R.id.pdf_root_view);
        controllerContainer = findViewById(R.id.button_group);
        loadingLayout = findViewById(R.id.loading_layout);
        contentRv = findViewById(R.id.content_rv);
        scrollSlider = findViewById(R.id.scroll_slider);

        pageLayoutManager = new RSPageLayoutManager(getContext(), RSPageLayoutManager.VERTICAL);
        pageLayoutManager.setOnPagerChangeListener(new IPageChangedListener() {
            @Override
            public void onInitFinish() {

            }

            @Override
            public void onReleaseListener(boolean isNext, int position) {
                scrollToPosition();
            }

            @Override
            public void onPageSelected(int position, boolean isBottom) {

            }
        });
        contentRv.setLayoutManager(pageLayoutManager);

        loadingLayout.setLoadLayoutListener(new RSPdfLoadingLayout.LoadLayoutListener() {
            @Override
            public void clickRetry() {
                if (!TextUtils.isEmpty(pdfUrl)) {
                    loadPdf(pdfUrl);
                }
            }
        });

        pageList = new ArrayList<>();
        pageAdapter = new RSPdfPageAdapter(getContext(), pageList, this);
        contentRv.setAdapter(pageAdapter);

        getOperateView().addPDFOperateListener(this);

        scrollSlider.setScrollSlideListener(new RsScrollSlider.ScrollSlideListener() {
            @Override
            public boolean scrolling(int scrollY) {
                int pageItemHeight = contentRv.getHeight() / pageCount;
                int scrollIndex = (int) scrollY / pageItemHeight;
                if(scrollIndex >= 0 && scrollIndex < pageLayoutManager.getItemCount()) {
                    scrollSlider.setTranslationY(scrollY - scrollY % pageItemHeight);
                    currentIndex = scrollIndex;
                    pageLayoutManager.scrollToPosition(currentIndex);
                    getOperateView().setThePageNumber(generatePageIndexText());
                }
                return true;
            }
        });

    }

    public void loadPdf(String url) {
        contentRv.setVisibility(GONE);
        loadingLayout.showLoading();
        if (!TextUtils.isEmpty(url)) {
            Log.d("ljm", "开始下载");
            if (url.startsWith("http")) {
                Log.d("ljm", "http开始下载");
                pdfUrl = url;
                serviceIntent = new Intent(getContext(), RSDownloadService.class);
                serviceIntent.putExtra(DOWNLOAD_URL_KEY, url);
                getContext().startService(serviceIntent);
            } else {
                pdfLocalPath = url;
                openPdf();
            }
        }
    }

    public void setPDFController(RSAbsControllerBar controller) {
        if (controllerContainer == null || controller == null) {
            return;
        }
        this.controllerContainer.removeAllViews();
        this.controllerContainer.addView(controller, 0);
        controller.getLayoutParams().width = MATCH_PARENT;
        controller.getLayoutParams().height = WRAP_CONTENT;
        controller.addPDFOperateListener(this);
    }

    private void scrollToPosition() {
        pageLayoutManager.scrollToPosition(currentIndex);
        getOperateView().setThePageNumber(generatePageIndexText());
        scrollSlider();
    }

    private void scrollSlider() {
        int pageItemHeight = contentRv.getHeight() / pageCount;
        float scrollDistance = currentIndex * pageItemHeight;
        scrollSlider.setTranslationY(scrollDistance);
    }

    private RSAbsControllerBar getOperateView() {
        return (RSAbsControllerBar) controllerContainer.getChildAt(0);
    }

    private RSDownloadResultBroadcast downloadReceiver;

    private void registerResultBroadcast() {
        downloadReceiver = new RSDownloadResultBroadcast();
        downloadReceiver.setResultCallback(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DOWNLOAD_ACTION);
        getContext().registerReceiver(downloadReceiver, intentFilter);
    }

    private void unregisterResultBroadcast() {
        getContext().unregisterReceiver(downloadReceiver);
    }

    private String generatePageIndexText() {
        return (currentIndex + 1) + "/" + pageCount;
    }

    private void openPdf() {
        renderTask = new RenderTask();
        renderTask.execute();
    }

    private ParcelFileDescriptor getFileDescriptor() {
        try {
            File file;
            if (pdfLocalPath.contains("asset")) {
                file = FileUtils.writeAssetsToFile(getContext(), pdfLocalPath);
            } else {
                file = new File(pdfLocalPath);
            }
            parcelFileDescriptor = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parcelFileDescriptor;
    }

    @Override
    public void downloadSuccess(String savePath) {

    }

    @Override
    public void downloadFail() {
        loadingLayout.showFail();
    }

    @Override
    public void downloadFinish(String savePath) {
        pdfLocalPath = savePath;
        if (TextUtils.isEmpty(pdfLocalPath)) {
            return;
        }
        openPdf();
    }

    @Override
    public void previousPage() {
        Log.d("ljm", "previousPage");
        currentIndex = pageLayoutManager.getCurrentPosition();
        if (currentIndex - 1 >= 0) {
            currentIndex--;
            scrollToPosition();
        }
    }

    @Override
    public void nextPage() {
        currentIndex = pageLayoutManager.getCurrentPosition();
        if(currentIndex + 1 < pageLayoutManager.getItemCount()) {
            currentIndex++;
            scrollToPosition();
        }
    }

    public void setPreviousText(String previousText) {
        if (controllerContainer != null && previousText != null) {
            RSAbsControllerBar controllerBar = (RSAbsControllerBar)controllerContainer.getChildAt(0);
            if (controllerBar != null) {
                controllerBar.setPreviousText(previousText);
            }
        }
    }

    public void setNextText(String nextText) {
        if (controllerContainer != null && nextText != null) {
            RSAbsControllerBar controllerBar = (RSAbsControllerBar)controllerContainer.getChildAt(0);
            if (controllerBar != null) {
                controllerBar.setNextText(nextText);
            }
        }
    }

    public class RenderTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                currentIndex = 0;
                pdfRenderer = new PdfRenderer(getFileDescriptor());
                pageCount = pdfRenderer.getPageCount();
                pageList.clear();
                for (int i=0; i<pageCount; i++) {
                    PdfRenderer.Page item = pdfRenderer.openPage(i);
                    curPdfPage = item;
                    int qualityRatio = getResources().getDisplayMetrics().densityDpi / (quality * 72);
                    Bitmap bitmap = Bitmap.createBitmap(qualityRatio * item.getWidth(), qualityRatio * item.getHeight(),
                            Bitmap.Config.ARGB_8888);
                    item.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
                    item.close();
                    pageList.add(bitmap);
                }
                hasRenderFinish = true;
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            if (result) {
                getOperateView().setThePageNumber(generatePageIndexText());
                pageAdapter.notifyDataSetChanged();
                contentRv.setVisibility(VISIBLE);
                loadingLayout.showContent();
            } else {
                loadingLayout.showFail();
            }
        }
    }

    public void release() {
        try {
            if (curPdfPage != null) {
                curPdfPage.close();
                curPdfPage = null;
            }
        } catch (Exception ignored) {

        }
        if (renderTask != null) {
            renderTask.cancel(true);
            renderTask = null;
        }
        unregisterResultBroadcast();
        if (serviceIntent != null) {
            getContext().stopService(serviceIntent);
        }
        if (hasRenderFinish && pdfRenderer != null) {
            pdfRenderer.close();
            pdfRenderer = null;
        }
        if (null != parcelFileDescriptor) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
