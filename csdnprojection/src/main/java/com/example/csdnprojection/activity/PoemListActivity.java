package com.example.csdnprojection.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.csdnprojection.R;

import java.util.ArrayList;

public class PoemListActivity extends AppCompatActivity {

    private static int POEM_COUNT = 11;

    private ListView lvPoemTitle;

    private ArrayAdapter<String> arrayAdapter;

    private String[] strPoemTitles;

    private String[] strPoemAuthors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_test);

        lvPoemTitle = findViewById(R.id.lv_poem_title);

        String[] authors = getResources().getStringArray(R.array.authors);
        String[] titles = getResources().getStringArray(R.array.titles);
        strPoemTitles = new String[POEM_COUNT];
        for (int i = 0; i < POEM_COUNT; i++) {
            strPoemTitles[i] = (i + 1) + "." + authors[i] + "." + titles[i];
        }

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strPoemTitles);

        lvPoemTitle.setAdapter(arrayAdapter);
        lvPoemTitle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = strPoemTitles[position];
                Intent intent = new Intent(PoemListActivity.this, PoemContentActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
//                Toast.makeText(PoemListActivity.this, title, Toast.LENGTH_SHORT).show();
            }
        });
    }
}