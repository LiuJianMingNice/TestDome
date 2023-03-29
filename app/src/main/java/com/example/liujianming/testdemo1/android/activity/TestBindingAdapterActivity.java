package com.example.liujianming.testdemo1.android.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import butterknife.ButterKnife;

import android.os.Bundle;

import com.example.liujianming.testdemo1.BR;
import com.example.liujianming.testdemo1.R;
import com.example.liujianming.testdemo1.android.viewmodel.TestBindingAdapterViewModel;
import com.example.liujianming.testdemo1.databinding.ActivityTestBindingAdapterBinding;

public class TestBindingAdapterActivity extends AppCompatActivity {

    ViewDataBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test_binding_adapter);
//        ButterKnife.bind(this, mBinding.getRoot());
//        mBinding.setViewModel(new TestBindingAdapterViewModel(this));
        mBinding.setVariable(BR.viewModel, new TestBindingAdapterViewModel(this));
    }
}