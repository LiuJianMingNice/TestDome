package com.example.liujianming.testdemo1.android.adapter;

import android.util.Log;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.liujianming.testdemo1.BR;
import com.example.liujianming.testdemo1.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public class RecyclerViewAdapter <T extends MultiItemEntity> extends BaseMultiItemQuickAdapter<T, BaseViewHolder> {

    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public RecyclerViewAdapter(List<T> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_local);
        addItemType(TYPE_LEVEL_1, R.layout.item_local_type2);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, T item) {
        ViewDataBinding binding = DataBindingUtil.bind(helper.itemView);
        binding.setVariable(BR.model, item);
        helper.addOnClickListener(R.id.ll_tab);
        helper.addOnClickListener(R.id.ll_tab_type2);
        binding.executePendingBindings();
    }
}
