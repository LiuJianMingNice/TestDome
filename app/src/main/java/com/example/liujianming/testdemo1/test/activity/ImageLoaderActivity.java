package com.example.liujianming.testdemo1.test.activity;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.liujianming.testdemo1.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.io.File;

public class ImageLoaderActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);
        mImageView = findViewById(R.id.image_loader);

        String imageUrl = "https://lh6.googleusercontent.com/-55osAWw3x0Q/URquUtcFr5I/AAAAAAAAAbs/rWlj1RUKrYI/s1024/A%252520Photographer.jpg";
        ImageSize imageSize = new ImageSize(100,100);
        ImageLoader.getInstance().loadImage(imageUrl,imageSize,new SimpleImageLoadingListener(){
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                Log.e("ljm","===onLoadingComplete===>>>");
                mImageView.setImageBitmap(loadedImage);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                super.onLoadingFailed(imageUri, view, failReason);
                Log.e("ljm","===onLoadingFailed===>>>" + failReason.getType());
                Log.e("ljm","===onLoadingFailed===>>>" + failReason.getCause());
            }

            @Override
            public void onLoadingStarted(String imageUri, View view) {
                super.onLoadingStarted(imageUri, view);
                Log.e("ljm","===onLoadingStarted===>>>");
            }
        });
    }

    private void loadingImageByGlide() {
        Cache cache = new Cache(new File(Environment.getExternalStorageDirectory() + "/okhttp_cache/"),100 * 1024 * 1024);


        OkHttpClient client = new OkHttpClient.Builder().cache(cache).build();




    }
}
