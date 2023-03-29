package com.example.jianshuprojection.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jianshuprojection.R;
import com.example.jianshuprojection.customview.SignatureView;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liujianming
 */
public class SignatureActivity extends AppCompatActivity {
    private Button bt_clear, bt_save;
    private SignatureView sv;
    private final String APP_DIR = "com.example.liujianming.testdemo1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);
        init();
    }

    private void init() {
        final String dir = Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+APP_DIR+File.separator;
        final File fileDir = new File(dir);
        if (!fileDir.exists()){
            fileDir.mkdirs();
        }

        bt_clear = (Button) findViewById(R.id.bt_clear_main_activity);
        sv = (SignatureView) findViewById(R.id.sv_main_activity);
        bt_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sv.clear();
            }
        });

        bt_save = (Button) findViewById(R.id.bt_save_main_activity);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(fileDir);
            }
        });
    }

    /**
     *  保存图片
     */
    private void save(File fileDir) {
        final String filePath = getFilePath(fileDir);
        if (sv.save(filePath)){//保存成功
            //发送广播 通知系统相册更新
            Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri uri = Uri.fromFile(new File(filePath));
            intent.setData(uri);
            sendBroadcast(intent);
            Toast.makeText(SignatureActivity.this, "保存成功！！！", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     *   得到图片的路径 以及图片的名字
     */
    private String getFilePath(File fileDir) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DateFormat.getDateTimeInstance();
        final String fileName = simpleDateFormat.format(new Date())+".png";
        Log.e("filename","---"+fileName);
        File file = new File(fileDir,fileName);
        return file.getAbsolutePath();
    }
}