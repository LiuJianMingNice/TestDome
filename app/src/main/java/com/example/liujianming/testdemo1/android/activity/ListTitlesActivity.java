package com.example.liujianming.testdemo1.android.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.liujianming.testdemo1.R;
import com.example.liujianming.testdemo1.android.fragment.ListTitlesFragment;

public class ListTitlesActivity extends AppCompatActivity {

    private ListTitlesFragment mListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_titles);

        FragmentManager fm = getSupportFragmentManager();
        mListFragment = (ListTitlesFragment) fm.findFragmentById(R.id.fragment_container);

        if (mListFragment == null) {
            mListFragment = new ListTitlesFragment();
            fm.beginTransaction().add(R.id.fragment_container, mListFragment).commit();
        }
    }
}