package com.example.admin.myanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.myanimation.activity.TweenActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mTweenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mTweenBtn = (Button)findViewById(R.id.tween_btn);
        mTweenBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tween_btn:
                clickTweenBtn();
                break;
            default:
                break;
        }
    }

    private void clickTweenBtn() {
        Intent intent = new Intent(this, TweenActivity.class);
        startActivity(intent);
    }
}
