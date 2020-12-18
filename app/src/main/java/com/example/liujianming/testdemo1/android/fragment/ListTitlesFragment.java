package com.example.liujianming.testdemo1.android.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.liujianming.testdemo1.R;
import com.example.liujianming.testdemo1.android.activity.ContentActivity;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListTitlesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListTitlesFragment extends ListFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static final int REQUEST_DETAIL = 0x110;
    private List<String> mTitles = Arrays.asList("Hello", "World", "Android");
    private int mCurrentPos ;
    private ArrayAdapter<String> mAdapter ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListTitlesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListTitlesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListTitlesFragment newInstance(String param1, String param2) {
        ListTitlesFragment fragment = new ListTitlesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_titles, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(mAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mTitles));
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        mCurrentPos = position;
        Intent intent = new Intent(getActivity(), ContentActivity.class);
        intent.putExtra(ContentFragment.ARGUMENT, mTitles.get(position));
        startActivityForResult(intent, REQUEST_DETAIL);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("ljm", "requestcode=%s resultCode=%s data=%s" + requestCode + resultCode + data);
        if (resultCode == Activity.RESULT_OK) {
            mTitles.set(mCurrentPos, mTitles.get(mCurrentPos) + "--" + data.getStringExtra(ContentFragment.REPONSE));
            mAdapter.notifyDataSetChanged();
        }
    }
}