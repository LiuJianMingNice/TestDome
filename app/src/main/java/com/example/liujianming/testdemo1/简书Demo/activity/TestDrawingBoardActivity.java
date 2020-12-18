package com.example.liujianming.testdemo1.简书Demo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.liujianming.testdemo1.R;
import com.example.liujianming.testdemo1.简书Demo.customview.DrawingBoardView;

public class TestDrawingBoardActivity extends AppCompatActivity {
    private DrawingBoardView drawingBoardView;
    private LinearLayout llChooserColor;
    private TextView clear;
    private int[] colors = new int[] {R.color.black, R.color.red, R.color.yellow, R.color.green, R.color.perpul};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_drawing_board);

        drawingBoardView = findViewById(R.id.drawingboardview);
        llChooserColor = findViewById(R.id.ll_choosecolor);
        clear = findViewById(R.id.tv_clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingBoardView.clearPanel();
            }
        });

        for (int i = 0; i < llChooserColor.getChildCount(); i++) {
            final int finalI = i;
            llChooserColor.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawingBoardView.setPaintColor(getResources().getColor(colors[finalI]));
                }
            });
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}