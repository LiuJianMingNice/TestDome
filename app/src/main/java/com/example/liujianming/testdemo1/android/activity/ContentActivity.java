package com.example.liujianming.testdemo1.android.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.liujianming.testdemo1.R;
import com.example.liujianming.testdemo1.android.fragment.ContentFragment;

public class ContentActivity extends AppCompatActivity {

    private ContentFragment mContentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        FragmentManager fm = getSupportFragmentManager();
        mContentFragment = (ContentFragment) fm.findFragmentById(R.id.fragment_container);

        if (mContentFragment == null) {
            String title = getIntent().getStringExtra(ContentFragment.ARGUMENT);
            mContentFragment = ContentFragment.newInstance(title);
            fm.beginTransaction().add(R.id.fragment_container,mContentFragment).commit();
        }
    }
}