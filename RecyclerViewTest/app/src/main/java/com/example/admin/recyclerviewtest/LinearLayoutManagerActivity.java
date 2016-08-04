package com.example.admin.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinearLayoutManagerActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private LinearLayoutManagerActivity.RVAdapter mAdapter;
    private List<String> mList;
    public LayoutInflater mInflater;
    private String mType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_manager);

        initData();
        initViews();
    }

    private void initData() {
        mList = new ArrayList<>();
        for(int i = 0; i < 33; i++){
            mList.add(i + " item");
        }
    }

    private void initViews() {
        mAdapter = new LinearLayoutManagerActivity.RVAdapter();
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);

        mRecyclerView.setAdapter(mAdapter);
        mInflater = LayoutInflater.from(this);

        mType = getIntent().getStringExtra("type");
        if(mType.equals("linear")) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                    DividerItemDecoration.VERTICAL_LIST));
        }else if(mType.equals("grid")){
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
            mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        }else if(mType.equals("stagger")){
            mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL));
            mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        }
    }

    public  class RVAdapter extends RecyclerView.Adapter<LinearLayoutManagerActivity.MViewHoder>{
        @Override
        public LinearLayoutManagerActivity.MViewHoder onCreateViewHolder(ViewGroup parent, int position) {
            View view = mInflater.inflate(R.layout.item, parent, false);
            LinearLayoutManagerActivity.MViewHoder hoder = new LinearLayoutManagerActivity.MViewHoder(view);
            return hoder;
        }

        @Override
        public void onBindViewHolder(LinearLayoutManagerActivity.MViewHoder holder, int position) {
            holder.mTv.setText(mList.get(position));
            if(mType.equals("stagger"))
            randomHeight(holder.mTv);

        }

        private void randomHeight(TextView mTv) {
            Random r = new Random();
            int i = r.nextInt() % 3;
            ViewGroup.LayoutParams params = mTv.getLayoutParams();
            if(i == 0) {
                params.height = 200;
            }else if(i == 1){
                params.height = 300;
            }else{
                params.height = 400;
            }
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }
    }

    private static class MViewHoder extends RecyclerView.ViewHolder{
        public TextView mTv;
        public MViewHoder(View itemView) {
            super(itemView);

            mTv = (TextView) itemView.findViewById(R.id.text_view);
        }
    }
}
