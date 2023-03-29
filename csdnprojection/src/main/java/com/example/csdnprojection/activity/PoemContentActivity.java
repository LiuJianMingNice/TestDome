package com.example.csdnprojection.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.csdnprojection.R;

public class PoemContentActivity extends AppCompatActivity {

    private TextView tv_title, tv_author, tv_content;
    private Button btn_back;
    private int position;

    private String[] titles;
    private String[] authors;
    private String[] contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poem_content);
        init();
        tv_title.setText(titles[position]);
        tv_author.setText(authors[position]);
        tv_content.setText(contents[position]);

    }

    private void init() {
        position = getIntent().getIntExtra("position", 0);

        tv_title = findViewById(R.id.lv_poem_title);
        tv_author = findViewById(R.id.lv_poem_author);
        tv_content = findViewById(R.id.lv_poem_content);
        btn_back = findViewById(R.id.lv_back);

        titles = getResources().getStringArray(R.array.titles);
        authors = getResources().getStringArray(R.array.authors);
        contents = getResources().getStringArray(R.array.contents);
    }

    public void doBack(View view) {
        finish();
    }
}