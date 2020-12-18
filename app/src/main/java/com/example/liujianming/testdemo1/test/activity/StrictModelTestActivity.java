package com.example.liujianming.testdemo1.test.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ImageView;

import com.example.liujianming.testdemo1.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StrictModelTestActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strict_model_test);
        imageView = findViewById(R.id.image_view);
//        bindStrictMode();
//        wirteToExternalStorageInMainThread();
        testBitmap();
    }

    private void bindStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build());

        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyDeath()
                .penaltyLog()
                .build());
    }

    public void wirteToExternalStorageInMainThread() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                File externalStorage = Environment.getExternalStorageDirectory();
                File destFile = new File(externalStorage,"hello.txt");
                OutputStream outputStream = null;
                try {
                    outputStream = new FileOutputStream(destFile,true);
                    outputStream.write("I am testing io".getBytes());
                    outputStream.flush();
                    outputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {

                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }).start();
    }

    public void testBitmap() {

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.mipmap.image);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(),R.mipmap.image,options);
        options.inJustDecodeBounds = false;
        imageView.setImageBitmap(bitmap);
//        imageView.setImageResource(R.mipmap.ic_launcher_round);
    }
}
