package com.example.liuwangshu.test.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import com.example.liuwangshu.R;

public class ObservableTestActivity extends AppCompatActivity {


    private static final String TAG = "ljm";
    String result = "数据来自：";
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observable_test);
//        testConcat();
        testMerge();
        View view;
    }


    //开发应用场景：从磁盘、内存缓存中获取缓存数据
    private void testConcat() {
        final String memoryCache = null;
        final String diskCache = "从磁盘缓存中获取数据";

        Observable<String> memory = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                if (memoryCache != null) {
                    emitter.onNext(memoryCache);
                } else {
                    emitter.onComplete();
                }
            }
        });

        Observable<String> disk = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                if (diskCache != null) {
                    emitter.onNext(diskCache);
                } else {
                    emitter.onComplete();
                }
            }
        });

        Observable<String> netWork = Observable.just("从网络获取数据");

        Observable.concat(memory, disk, netWork)
                .firstElement()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.d(TAG, "最后获取的数据来自: " + s);
                    }
                });
    }

    private void testMerge() {
        Observable<String> network = Observable.just("网络");
        Observable<String> file = Observable.just("本地文件");
        Observable.merge(network, file)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "数据源有: " + s);
                        result += s + "+";
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                        Log.d(TAG, "数据: " + result);
                    }
                });
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: ");
        super.onStart();
        onRestoreInstanceState(bundle);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        bundle = outState;
        Log.d(TAG, "onSaveInstanceState: ");
        outState.putBoolean("MyBoolean", true);
        outState.putDouble("MyDouble", 1.9);
        outState.putInt("MyInt", 1);
        outState.putString("MyString", "Welcome back to Android");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: ");
        if (bundle == null)
            return;
        super.onRestoreInstanceState(savedInstanceState);

        boolean myBoolean = savedInstanceState.getBoolean("MyBoolean");
        double myDouble = savedInstanceState.getDouble("MyDouble");
        int myInt = savedInstanceState.getInt("MyInt");
        String myString = savedInstanceState.getString("MyString");
        Log.d("ljm", "myBoolean=" + myBoolean + ",myDouble=" + myDouble
                    + ",myInt=" + myInt + ",myString=" + myString);
    }
}