package com.example.wwq_123.readhub.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.adapter.DataNewsArrayAdapter;
import com.example.wwq_123.readhub.model.bean.DataItem;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;


public class ShowDataActivity extends AppCompatActivity{

    private TextView title;
    private TextView summary;
    private DataItem data;
    private RecyclerView newsArray;
    private DataNewsArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        initView();
        initData();
        initRecycleView();
    }

    private void initRecycleView() {
        TopicDataItem item = (TopicDataItem) data;
        adapter = new DataNewsArrayAdapter(this,item.getNewsArray());
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(OrientationHelper.VERTICAL);
        newsArray.setLayoutManager(manager);
        newsArray.addItemDecoration(new MyItemDecoration());
        newsArray.setAdapter(adapter);
    }

    private void initData() {
        Intent intent = getIntent();
        data = (TopicDataItem) intent.getSerializableExtra("data");
        title.setText(data.getTitle());
        summary.setText(data.getSummary());
    }

    private void initView() {
        title = findViewById(R.id.data_title);
        summary = findViewById(R.id.data_summary);
        newsArray = findViewById(R.id.newsArray_list);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
