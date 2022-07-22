package com.example.pdfhelper.rspdfview.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.pdfhelper.R;
import com.example.pdfhelper.rspdfview.RSPdfView;
import com.example.pdfhelper.rspdfview.widget.RSScaleImageView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 * <p>
 * RSPdfPageAdapter
 *
 * @author liujianming
 * @date 2022-07-20
 */
public class RSPdfPageAdapter extends RecyclerView.Adapter<RSPdfPageAdapter.ViewHolder> {

    private Context mContext;
    private RSPdfView mPdfView;
    private List<Bitmap> pageList;

    public RSPdfPageAdapter(Context context, List<Bitmap> pageList, RSPdfView rsPdfView) {
        this.mContext = context;
        this.pageList = pageList;
        this.mPdfView = rsPdfView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RSPdfPageAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.rs_layout_page_item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bitmap item = pageList.get(position);
        holder.itemIv.setLayoutParams(new FrameLayout.LayoutParams(mContext.getResources().getDisplayMetrics().widthPixels, mContext.getResources().getDisplayMetrics().heightPixels - 300));
        holder.itemIv.setImageBitmap(item);
        holder.itemIv.addPDFOperateListener(mPdfView);
    }

    @Override
    public int getItemCount() {
        return pageList.size();
    }

    @Override
    public void onViewAttachedToWindow(@NonNull ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.itemIv.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        RSScaleImageView itemIv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemIv = itemView.findViewById(R.id.pdf_page_iv);
        }
    }
}
