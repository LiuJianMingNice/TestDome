package com.example.csdnprojection.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.csdnprojection.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.util.Arrays;

public class FileOperationActivity extends AppCompatActivity {

    private TextView tvFileContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_opration);

        tvFileContent = findViewById(R.id.tvFileContent);
    }

    public void doReadRawFile(View view) {
        InputStream in = getResources().openRawResource(R.raw.test);
        try {
            int length = in.available();
            byte[] buffer = new byte[length];
            in.read(buffer);
            in.close();
            String content = new String(buffer, "utf-8");
            tvFileContent.setText(content);
            tvFileContent.setTextColor(Color.BLUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doReadAssetsFile(View view) {
        String fileName = "test.txt";
        try {
            InputStream in = getResources().getAssets().open(fileName);
            StringBuilder builder = new StringBuilder();
            byte[] buffer = new byte[512];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                builder.append(new String(Arrays.copyOf(buffer, len), "utf-8"));
            }
            in.close();
            String content = builder.toString();
            tvFileContent.setText(content);
            tvFileContent.setTextColor(Color.BLUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doWriteAppFile(View view) {
        String fileName = "test.txt";
        int mode = Context.MODE_PRIVATE;

        try {
            FileOutputStream fos = openFileOutput(fileName, mode);
            String content = "登黄鹤楼\n\n白日依山尽,\n黄河入海流.\n欲穷千里目,\n更上一城楼.";
            byte[] buffer = content.getBytes("UTF8");
            fos.write(buffer);
            fos.close();
            Toast.makeText(this,"恭喜,写入文件成功", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this,"恭喜,写入文件失败", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }

    public void doReadAppFile(View view) {
        String fileName = "test.txt";

        try {
            FileInputStream fis = openFileInput(fileName);
            int length = fis.available();
            byte[] buffer = new byte[length];
            fis.read(buffer);
            fis.close();
            String content = new String(buffer, "UTF8");
            tvFileContent.setTextColor(Color.GREEN);
            tvFileContent.setTextSize(20);
            tvFileContent.setText(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doWriteSDCardFile(View view) {
    }

    public void doReadSDCardFile(View view) {

    }
}