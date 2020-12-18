package com.example.liujianming.testdemo1.test.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.liujianming.testdemo1.R;

public class TestScreenActivity extends AppCompatActivity {

    private ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_screen);

        imageView1 = findViewById(R.id.image1);
        imageView2 = findViewById(R.id.image2);

        Log.e("ljm","获得屏幕高度: " + getScreenWidth(this));
        Log.e("ljm","获得屏幕宽度: " + getScreenHeight(this));
        Log.e("ljm","获取屏幕密度: " + getScreenDensity(this));
        Log.e("ljm","获得状态栏的高度: " + getStatusHeight(this));
//        Log.e("ljm","获取当前屏幕截图，包含状态栏: " + snapShotWithStatusBar(this));
//        Log.e("ljm","获取当前屏幕截图，不包含状态栏: " + snapShotWithoutStatusBar(this));

//        imageView1.setImageBitmap(snapShotWithStatusBar(this));
//        imageView2.setImageBitmap(snapShotWithoutStatusBar(this));
    }

    /**
     * 获得屏幕高度
     * @param context
     * @return
     * by Hankkin at:2015-10-07 21:15:59
     */
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * 获得屏幕宽度
     * @param context
     * @return
     * by Hankkin at:2015-10-07 21:16:13
     */
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    /**
     * 获取屏幕密度
     * @param context
     * @return
     * by Hankkin at:2015-10-07 21:16:29
     */
    public static float getScreenDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /**
     * 获得状态栏的高度
     * @param context
     * @return
     * by Hankkin at:2015-10-07 21:16:43
     */
    public static int getStatusHeight(Context context) {
        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }

    /**
     * 获取当前屏幕截图，包含状态栏
     * @param activity
     * @return
     * by Hankkin at:2015-10-07 21:16:43
     */
    public static Bitmap snapShotWithStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, 0, width, height);
        view.destroyDrawingCache();
        return bp;
    }

    /**
     * 获取当前屏幕截图，不包含状态栏
     * @param activity
     * @return
     * by Hankkin at:2015-10-07 21:16:43
     */
    public static Bitmap snapShotWithoutStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height
                - statusBarHeight);
        view.destroyDrawingCache();
        return bp;
    }
}
