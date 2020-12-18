package com.example.liujianming.testdemo1.android.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.liujianming.testdemo1.R;
import com.example.liujianming.testdemo1.android.fragment.FragmentOne;
import com.example.liujianming.testdemo1.android.fragment.FragmentThree;
import com.example.liujianming.testdemo1.android.fragment.FragmentTwo;
import com.example.liujianming.testdemo1.android.utils.RSKeys;

public class TestFragment1Activity extends AppCompatActivity implements FragmentOne.FOneBtnClickListener, FragmentTwo.FTwoBtnClickListener {

    private int mViewType = 0;

    private FragmentOne mOne;
    private FragmentTwo mTwo;
    private FragmentThree mThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment1);
        mViewType = getIntent().getIntExtra(RSKeys.FRAGMENT_INTENT, 0);

        mOne = new FragmentOne();
        mTwo = new FragmentTwo();
        mThree = new FragmentThree();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.add(R.id.id_content, mOne, "ONE");
        tx.commit();
    }

    @Override
    public void onFOneBtnClick() {
        if (mTwo != null) {
            mTwo.setFTwoBtnClickListener(this);
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.replace(R.id.id_content, mTwo, "TWO");
        tx.addToBackStack(null);
        tx.commit();
    }

    @Override
    public void onFTwoBtnClick() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.replace(R.id.id_content, mThree, "THREE");
        tx.addToBackStack(null);
        tx.commit();
    }
}