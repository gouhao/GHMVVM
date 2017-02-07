package com.gouhao.frametest.main;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gouhao.frametest.R;
import com.gouhao.frametest.databinding.ItemListBinding;

/**
 * Created by gouhao on 2017/2/7 0007.
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.Holder> {
    private OnItemClickListener onItemClickListener;
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        final ItemListBinding itemListBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_list, parent, false);
        Holder holder = new Holder(itemListBinding);
        return holder;
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        holder.getDataBinding().setText("Item " + (position + 1));
        holder.getDataBinding().getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener != null) {
                    onItemClickListener.onItemClick(holder.getDataBinding(), position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
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

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(ItemListBinding dataBinding, int position);
    }
}
