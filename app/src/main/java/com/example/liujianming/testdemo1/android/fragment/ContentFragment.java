package com.example.liujianming.testdemo1.android.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liujianming.testdemo1.R;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContentFragment extends Fragment {

    private String mArgument;
    public static final String ARGUMENT = "argument";
    public static final String REPONSE = "response";
    public static final String EVALUATE_DIALOG = "evaluate_dialog";
    public static final int REQUEST_EVALUATE = 0x110;

    public ContentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ContentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContentFragment newInstance(String argument) {
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString(ARGUMENT, argument);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mArgument = bundle.getString(ARGUMENT);
            Log.d("ljm","mArgument===>>> " + mArgument);
            Intent intent = new Intent();
            intent.putExtra(REPONSE, "good");
            getActivity().setResult(ListTitlesFragment.REQUEST_DETAIL, intent);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Random random = new Random();
        TextView tv = new TextView(getActivity());
        tv.setText(mArgument);
        tv.setGravity(Gravity.CENTER);
        tv.setBackgroundColor(Color.argb(random.nextInt(100), random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EvaluateDialog evaluateDialog = new EvaluateDialog();
                evaluateDialog.setTargetFragment(ContentFragment.this, REQUEST_EVALUATE);
                evaluateDialog.show(getFragmentManager(), EVALUATE_DIALOG);
            }
        });
        return tv;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_EVALUATE) {
            String evaluate = data.getStringExtra(EvaluateDialog.RESPONSE_EVALUATE);
            Toast.makeText(getActivity(), evaluate, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.putExtra(REPONSE, evaluate);
            getActivity().setResult(Activity.RESULT_OK, intent);
        }
    }
}