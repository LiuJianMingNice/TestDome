package com.example.liujianming.testdemo1.android.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.liujianming.testdemo1.R;
import com.example.liujianming.testdemo1.android.adapter.RecyclerViewAdapter;
import com.example.liujianming.testdemo1.android.utils.MyConstants;
import com.example.liujianming.testdemo1.android.utils.RSKeys;
import com.example.liujianming.testdemo1.android.viewmodel.RecyclerViewModel;
import com.example.liujianming.testdemo1.databinding.ActivityRecyclerViewBinding;

public class RecyclerViewActivity extends AppCompatActivity implements BaseQuickAdapter.OnItemChildClickListener{

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    ActivityRecyclerViewBinding mBinding;
    RecyclerViewModel mRecyclerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
//        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this, mBinding.getRoot());
        mRecyclerViewModel = new RecyclerViewModel();
        mBinding.setRecyclerviewmodel(mRecyclerViewModel);
        mRecyclerViewModel.initData();
        initRecyclerView();

    }

    private void initRecyclerView() {
        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        decoration.setDrawable(getResources().getDrawable(R.drawable.shape_line));
        recyclerView.addItemDecoration(decoration);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mRecyclerViewModel.mRecyclerViewItemModels);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter.setOnItemChildClickListener(this);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (position) {
            case 0:
                Toast.makeText(this,"1",Toast.LENGTH_LONG).show();
                privateViewParentHierarchy(view, 0);
                break;
            case 1:
                Toast.makeText(this,"2",Toast.LENGTH_LONG).show();
                break;
            case 2:
                Intent intent1 = new Intent(this,TestFragment1Activity.class);
                intent1.putExtra(RSKeys.FRAGMENT_INTENT, MyConstants.FRAGMENT_VIEW_TYPE_1);
                startActivity(intent1);
                break;
            case 3:
                Intent intent2 = new Intent(this,TestFragment1Activity.class);
                intent2.putExtra(RSKeys.FRAGMENT_INTENT, MyConstants.FRAGMENT_VIEW_TYPE_2);
                startActivity(intent2);
                break;
            case 4:
                Intent intent3 = new Intent(this,TestFragment1Activity.class);
                intent3.putExtra(RSKeys.FRAGMENT_INTENT, MyConstants.FRAGMENT_VIEW_TYPE_3);
                startActivity(intent3);
                break;
        }
    }

    private void privateViewParentHierarchy(Object view, int level) {
        if (view == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("\t");
        }
        sb.append(view.getClass().getSimpleName());
        Log.d("ljm", sb.toString());

        if (view instanceof View) {
            privateViewParentHierarchy(((View) view).getParent(), level + 1);
        }
    }
}