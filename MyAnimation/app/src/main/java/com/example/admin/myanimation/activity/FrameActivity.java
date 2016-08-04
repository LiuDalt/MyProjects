package com.example.admin.myanimation.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.myanimation.R;


public class FrameActivity extends BaseActivity implements IAnimation, View.OnClickListener{

    private ImageView mXmlImgv;
    private Button mXml;
    private Button mCustom;
    private AnimationDrawable mXmlAnim;
    private AnimationDrawable mCustAnim;
    private ImageView mCustImgv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        initViews();
        initAnimations();
        initListener();
    }

    @Override
    public void initViews() {
        mXmlImgv = (ImageView)findViewById(R.id.frame_imgv_xml);
        mCustImgv = (ImageView)findViewById(R.id.frame_imgv_cust);
        mXml = (Button)findViewById(R.id.xml_frame_btn);
        mCustom = (Button)findViewById(R.id.custom_frame_btn);
    }

    @Override
    public void initAnimations() {
        mXmlAnim = (AnimationDrawable)getResources().getDrawable(R.drawable.frame);
        mXmlImgv.setBackground(mXmlAnim);

        mCustAnim =new AnimationDrawable();
        mCustAnim.setOneShot(false);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img0), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img1), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img2), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img3), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img4), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img5), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img6), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img7), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img8), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img9), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img10), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img11), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img12), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img13), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img14), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img15), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img16), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img17), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img18), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img19), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img20), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img21), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img22), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img23), 50);
        mCustAnim.addFrame(getResources().getDrawable(R.drawable.img24), 50);
        mCustImgv.setBackground(mCustAnim);
    }

    @Override
    public void initListener() {
         mXml.setOnClickListener(this);
         mCustom.setOnClickListener( this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.xml_frame_btn:
                clickXmlFrameBtn();
                break;
            case R.id.custom_frame_btn:
                clickCustFrameBtn();
                break;
            default:
                break;
        }
    }

    private void clickCustFrameBtn() {
        if(mCustAnim.isRunning()){
            mCustAnim.stop();
            return;
        }
        mCustAnim.start();
    }

    private void clickXmlFrameBtn() {
        if(mXmlAnim.isRunning()){
            mXmlAnim.stop();
            return;
        }
        mXmlAnim.start();
    }
}
