package com.gouhao.frametest.main;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.gouhao.frame.base.BaseActivity;
import com.gouhao.frametest.R;
import com.gouhao.frametest.databinding.ActivityMainBinding;
import com.gouhao.frametest.databinding.ItemListBinding;

/**
 * Created by gouhao on 2017/2/3 0003.
 */
public class MainActivity extends BaseActivity<ActivityMainBinding,
        MainModel, MainActivityData> {

    @Override
    protected void initActivityDataBinding() {
        activityDataBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.activity_main, null, false);
        MainListAdapter adapter = new MainListAdapter();
        adapter.setOnItemClickListener(new MainListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ItemListBinding dataBinding, int position) {
                Toast.makeText(MainActivity.this, "Item " + (position + 1) + " clicked", 400).show();
            }
        });
        activityDataBinding.recyclerView.setAdapter(adapter);
        activityDataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        activityDataBinding.recyclerView.setHasFixedSize(true);
        activityDataBinding.recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void initActivityData() {
        activityData = new MainActivityData();
        activityData.buttonText1.set("Add Item");
        activityData.buttonText2.set("Show/Hide Label");
        activityData.isShowLabelText.set(true);
        activityData.labelText.set("This is a label!");
        activityDataBinding.setData(activityData);
    }

    @Override
    protected void initActivityModel() {
        activityModel = new MainModel(activityDataBinding);
        activityDataBinding.setModel(activityModel);
    }
    @Override
    protected void initTitle() {
        getTitleBar().setTitleBarTitle("Gouhao");
    }
}
