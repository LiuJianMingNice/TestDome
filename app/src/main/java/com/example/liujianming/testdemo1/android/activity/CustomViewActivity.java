package com.example.liujianming.testdemo1.android.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import com.example.liujianming.testdemo1.R;

@RuntimePermissions
public class CustomViewActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        mButton = findViewById(R.id.button);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animation_test);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(300);
        mButton.startAnimation(alphaAnimation);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAnimate();
                getPermission();
                CustomViewActivityPermissionsDispatcher.doTalkWithPermissionCheck(CustomViewActivity.this);
            }
        });
    }

    private void performAnimate() {
        Log.d("ljm", "22222111");
        ObjectAnimator.ofInt(mButton, "width", 500).setDuration(5000).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Log.d("ljm", "111112222");
                performAnimate();
                break;
            default:
                break;
        }
    }

    private void getPermission() {
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED){
            Log.d("ljm", "获取权限");;
            ActivityCompat.requestPermissions(this,new String[]{
                    android.Manifest.permission.RECORD_AUDIO},1);
        }else {
            Log.d("ljm", "已经获取");
        }
    }

    @NeedsPermission(android.Manifest.permission.RECORD_AUDIO)
    void doTalk() {
        Log.d("ljm", "nihao");
    }

    @OnPermissionDenied(android.Manifest.permission.RECORD_AUDIO)
    void noDoTalk() {
        Log.d("ljm", "不能对讲");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        CustomViewActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
}