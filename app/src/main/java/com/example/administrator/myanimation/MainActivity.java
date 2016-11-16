package com.example.administrator.myanimation;

import android.animation.ValueAnimator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //所有的动画都是点击这个图片开始的
        imageView = (ImageView) findViewById(R.id.image);
        initListener();
    }

    private void initListener() {
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        ObjectAnimation测试
        ObjectAnimationUtils.rotationX(v);
        ObjectAnimationUtils.translationX(v);
        ObjectAnimationUtils.rotation(v);
        ObjectAnimationUtils.rotationY(v);
        ObjectAnimationUtils.animSet(v);
        ObjectAnimationUtils.translationY(v);
        ObjectAnimationUtils.objectSet(v);
        ObjectAnimationUtils.propertyValuesSet(v);
        ValueAnimationUtils.valueAnim(v);
    }
}
