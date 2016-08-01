package com.example.admin.myanimation.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);

        initViews();
    }
    @Override
    public void initViews(){
        mImgv =  (ImageView)findViewById(R.id.img_tween);
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

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(myAnimation_Alpha);
    }

    @Override
    public void initListener() {
        mImgv.setOnClickListener(this);
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
            default:
                break;
        }
    }

    private void restartAnim() {
        mImgv.startAnimation(mXmlTween);
    }
}
