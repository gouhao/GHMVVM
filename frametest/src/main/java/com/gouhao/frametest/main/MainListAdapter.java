package com.gouhao.frametest.main;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gouhao.frametest.R;
import com.gouhao.frametest.databinding.ItemListBinding;

/**
 * Created by gouhao on 2017/2/7 0007.
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.Holder> {
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemListBinding itemListBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_list, null, false);
        Holder holder = new Holder(itemListBinding);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.getDataBinding().setText("Item " + (position + 1));
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ItemListBinding dataBinding;

        public Holder(ItemListBinding dataBinding) {
            super(dataBinding.getRoot());
            this.dataBinding = dataBinding;
        }

        public ItemListBinding getDataBinding() {
            return dataBinding;
        }
    }
}
