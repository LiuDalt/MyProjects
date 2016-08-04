package com.example.admin.recyclerviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

/**
 * 务必在build.gradle中添加：compile 'com.android.support:recyclerview-v7:24.1.1'
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public LayoutInflater mInflater;
    private Button mLinearBtn;
    private Button mGridBtn;
    private Button mStrage;
    private Button mStaggerBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initViews();
    }

    private void initData() {
    }

    private void initViews() {
        mLinearBtn = (Button) findViewById(R.id.line_bt);
        mGridBtn = (Button) findViewById(R.id.grid);
        mStaggerBtn = (Button) findViewById(R.id.stagger);
        mLinearBtn.setOnClickListener(this);
        mGridBtn.setOnClickListener(this);
        mStaggerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.line_bt:
                go("linear");
                break;
            case R.id.grid:
                go("grid");
                break;
            case R.id.stagger:
                go("stagger");
            default:
                break;
        }
    }

    private void go(String str) {
        Intent intent = new Intent();
        intent.putExtra("type", str);
        intent.setClass(this, LinearLayoutManagerActivity.class);
        startActivity(intent);
    }
}