package com.example.liujianming.testdemo1.android.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.liujianming.testdemo1.R;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class EvaluateDialog extends DialogFragment {

    private ListView mListView;
    private List<String> mContents = Arrays.asList("GOOD", "BAD", "NORMAL");
    public static final String RESPONSE_EVALUATE = "response_evaluate";

    private String[] mEvaluteVals = new String[] { "GOOD", "BAD", "NORMAL" };


//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.evaluate_dialog,container);
//        initData(view);
//        return view;
//    }
//
//    public void initData(View view) {
//        mListView = view.findViewById(R.id.dialog_content);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1,mContents);//新建并配置ArrayAapeter
//        mListView.setAdapter(adapter);
//    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Evaluate : ").setItems(mEvaluteVals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setResult(which);
            }
        });
        return builder.create();
    }

    //设置返回数据
    protected void setResult(int which) {
        if (getTargetFragment() == null) {
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(RESPONSE_EVALUATE, mEvaluteVals[which]);
        getTargetFragment().onActivityResult(ContentFragment.REQUEST_EVALUATE, Activity.RESULT_OK, intent);
    }
}
