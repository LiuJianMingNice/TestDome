package com.example.liujianming.testdemo1.android.viewmodel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liujianming.testdemo1.R;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

public class TestBindingAdapterViewModel {

    private Context mContext ;
    public final ObservableField<Drawable> srcResource = new ObservableField<>();
    public ObservableField<String> content = new ObservableField<>("hhh");

    public TestBindingAdapterViewModel(Context context) {
        Log.d("ljm", "==TestBindingAdapterViewModel==>>> " + content.get());
        mContext = context;
        content.set("ooo");
        srcResource.set(mContext.getResources().getDrawable(R.drawable.ic_show_error));
    }

    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }

    @BindingAdapter({"android:text"})
    public static void setTextView(TextView textView, String str) {
        textView.setText(str);
    }


}
