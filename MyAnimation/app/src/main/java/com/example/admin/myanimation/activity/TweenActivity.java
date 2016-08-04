package com.example.admin.myanimation.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.myanimation.R;
import com.example.admin.myanimation.common.MLog;

/**
 * Created by admin on 2016/8/1.
 */

public class TweenActivity extends BaseActivity implements IAnimation, View.OnClickListener{
    private ImageView mImgv;
    private Animation mXmlTween;
    //在代码中定义 动画实例对象
    private Animation myAnimation_Alpha;
    private Animation myAnimation_Scale;
    private Animation myAnimation_Translate;
    private Animation myAnimation_Rotate;
    private AnimationSet mCustomAnimationSet;
    private Button mXmlBtn;
    private Button mCustomBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);

        initViews();
    }
    @Override
    public void initViews(){
        mImgv =  (ImageView)findViewById(R.id.img_tween);
        mXmlBtn = (Button) findViewById(R.id.xml_tween_btn);
        mCustomBtn = (Button)findViewById(R.id.custom_tween_btn);
        initAnimations();
        initListener();
    }

    @Override
    public void initAnimations() {
        mXmlTween = AnimationUtils.loadAnimation(this, R.anim.tween);
        mImgv.startAnimation(mXmlTween);

        myAnimation_Alpha = new AlphaAnimation(0.1f, 1.0f);

        myAnimation_Scale = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        myAnimation_Translate = new TranslateAnimation(30.0f, -80.0f, 30.0f, 300.0f);

        myAnimation_Rotate = new RotateAnimation(0.0f, +350.0f,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF, 0.5f);

        mCustomAnimationSet = new AnimationSet(true);
        mCustomAnimationSet.addAnimation(myAnimation_Alpha);
        mCustomAnimationSet.addAnimation(myAnimation_Scale);
        mCustomAnimationSet.addAnimation(myAnimation_Rotate);
        mCustomAnimationSet.addAnimation(myAnimation_Rotate);
        mCustomAnimationSet.setDuration(5000);
    }

    @Override
    public void initListener() {
        mImgv.setOnClickListener(this);
        mCustomBtn.setOnClickListener(this);
        mXmlBtn.setOnClickListener(this);
        mXmlTween.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                MLog.e(MLog.Mylog, "xml Tween start");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                MLog.e(MLog.Mylog, "xml Tween end");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                MLog.e(MLog.Mylog, "xml Tween repeat");
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_tween:
                restartAnim();
                break;
            case R.id.xml_tween_btn:
                mImgv.startAnimation(mXmlTween);
                break;
            case R.id.custom_tween_btn:
                mImgv.startAnimation(mCustomAnimationSet);
                break;
            default:
                break;
        }
    }

    private void restartAnim() {
//        if(mImgv.getAnimation().equals(mXmlTween)){
//            Log.e("mylog", "current animation is xmltween");
//        }else if(mImgv.getAnimation().equals(mCustomAnimationSet)){
//            Log.e("mylog", "current animation is customAnimationSet");
//        }else{
//            Log.e("mylog", "no animation");
//        }
//        mImgv.startAnimation(mImgv.getAnimation());
    }
}
