package com.example.developandart.chapter_3.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developandart.R;
import com.example.developandart.chapter_3.customview.HorizontalScrollViewEx;
import com.example.developandart.chapter_3.utils.MyUtils;

import java.util.ArrayList;

public class SlidingConflictActivity extends AppCompatActivity {

    private static final String TAG = "ljm";

    private HorizontalScrollViewEx mListContainer;

    private View view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_conflict);
        initView();
    }

    private void initView() {
        LayoutInflater inflater = getLayoutInflater();
        view = getWindow().getDecorView();
        mListContainer = findViewById(R.id.container);
        final int screenWidth = MyUtils.getScreenMetrics(this).widthPixels;
        final int screenHeight = MyUtils.getScreenMetrics(this).heightPixels;
        for (int i = 0; i < 3; i++) {
            ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.content_layout, mListContainer, false);
            layout.getLayoutParams().width = screenWidth;
            TextView textView = layout.findViewById(R.id.title);
            textView.setText("page " + (i + 1));
            layout.setBackgroundColor(Color.rgb(255 / (i + 1), 255 / (i +1), 0));
            createList(layout);
            mListContainer.addView(layout);
        }
    }

    private void createList(ViewGroup layout) {
        ListView listView = (ListView) layout.findViewById(R.id.list);
        ArrayList<String> datas = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            datas.add("name " + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.content_list_item, R.id.name, datas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(SlidingConflictActivity.this, "click item",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        view.post(new Runnable() {
            @Override
            public void run() {
                int width = view.getMeasuredWidth();
                int height = view.getMeasuredHeight();
                Log.d("ljm", "onStart==width===>>> " + width + ",height===>>> " + height);
            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        int width = view.getMeasuredWidth();
        int height = view.getMeasuredHeight();
        int containerWidth = mListContainer.getMeasuredWidth();
        int containerHeight = mListContainer.getMeasuredHeight();
        Log.d("ljm", "onWindowFocusChanged==width===>>> " + width + ",height===>>> " + height);
        Log.d("ljm", "onWindowFocusChanged==containerWidth===>>> " + containerWidth + ",containerHeight===>>> " + containerHeight);
    }
}