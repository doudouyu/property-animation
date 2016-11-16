package com.example.administrator.myanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;

/**
 * Created by bean on 2016/11/11.
 * ObjectAnimation基本用法，平移，旋转，动画集合，（ofInt，ofObject未测试）ofFloat用法如下
 */
public class ObjectAnimationUtils {

    //是用animationSet实现动画集合
    public static void animSet(View v) {
        ObjectAnimator o1 = ObjectAnimator.ofFloat(v, "rotationX", 0.0F, 180F);
        ObjectAnimator o2 = ObjectAnimator.ofFloat(v, "rotationY", 0.0F, 180F);
        ObjectAnimator o3 = ObjectAnimator.ofFloat(v, "translationX", 0.0F, 180F);
        ObjectAnimator o4 = ObjectAnimator.ofFloat(v, "rotation", 0.0F, 180F);
        //专门实现动画集的一个类
        AnimatorSet set = new AnimatorSet();
        set.play(o1).with(o2).after(o3).before(o4);
        set.setDuration(2000);
        set.start();
    }

    //是用objectanimation实现动画集合
    public static void objectSet(final View v) {
//        把设置属性的这个字符串，随便写一个该对象没有的属性，咱们只需要它按照时间插值和持续时间计算的那个值，在下面我们自己手动调用
        ObjectAnimator oo = ObjectAnimator.ofFloat(v, "ydd", 0.0F, 1.0F);
        //设置动画持续的时长
        oo.setDuration(5000);
        //设置动画重复播放的次数
        oo.setRepeatCount(5);
        //设置冲新开始动画的模式
        oo.setRepeatMode(ObjectAnimator.RESTART);
        //开启动画
        oo.start();
        oo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //自己手动调用
                float f = (float) animation.getAnimatedValue();
                //缩放  目测f可以随便写
                v.setScaleX(f);
//                v.setScaleY(f);
                //透明度
                v.setAlpha(f);
                //平移
//                v.setTranslationX(180);
                v.setTranslationY(180);
                //这个方法需要最低版本为14
//                v.setTranslationZ(f);
                //反转
//                v.setRotationX(180);
                v.setRotationY(360);
            }
        });
    }

    //  是用propertyValuesHolder用一个动画实现多种效果
    public static void propertyValuesSet(View v) {
        PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("rotationY", 0f, 180f, 180f);
        PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("translationX", -180f, 180f, 180f);
        PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("rotation", -180f, 0f, 180f);
        ObjectAnimator.ofPropertyValuesHolder(v,holder1,holder2,holder3).setDuration(1000).start();
    }

    //原地以自己的横轴为基准线旋转360度
    public static void rotationX(View v) {
        //正传
//        ObjectAnimator.ofFloat(v, "rotationX", 0.0F, 360.0F).setDuration(500).start();
        //反转
        ObjectAnimator.ofFloat(v, "rotationX", 0.0F, -360.0F).setDuration(500).start();
    }

    //原地以自己的纵轴为基准线旋转360度
    public static void rotationY(View v) {
//        ObjectAnimator.ofFloat(v, "rotationY", 0.0F, 360.0F).setDuration(500).start();
        ObjectAnimator.ofFloat(v, "rotationY", 0.0F, -360.0F).setDuration(500).start();
    }

    //左右平移
    public static void translationX(View v) {
        //在500毫秒时间内做平移动画，不回来
        //正数向右
        ObjectAnimator.ofFloat(v, "translationX", 0.0F, 360.0F).setDuration(500).start();
        //负数向左
        ObjectAnimator.ofFloat(v, "translationX", 0.0F, -360.0F).setDuration(500).start();
        //在500毫秒时间内做平移动画，在回来
//        ObjectAnimator.ofFloat(v, "translationX", 180.0F, 0.0F).setDuration(500).start();
    }

    //上下平移
    public static void translationY(View v) {
        //在500毫秒时间内做平移动画，不回来
        //正数向上
//        ObjectAnimator.ofFloat(v, "translationY", 0.0F, 360.0F).setDuration(500).start();
        //负数向下
//        ObjectAnimator.ofFloat(v, "translationY", 0.0F, -360.0F).setDuration(500).start();
        //在500毫秒时间内做平移动画，在回来
        ObjectAnimator.ofFloat(v, "translationY", 180.0F, 0.0F).setDuration(500).start();
    }

    //以自己的中心点为中心旋转360度
    public static void rotation(View v) {
        //顺时针
//        ObjectAnimator.ofFloat(v, "rotation", 0.0F, 360.0F).setDuration(500).start();
//        ObjectAnimator.ofFloat(v, "rotation", -360.0F, 0.0F).setDuration(500).start();
        //逆时针
//        ObjectAnimator.ofFloat(v, "rotation", 360.0F, 0.0F).setDuration(500).start();
        ObjectAnimator.ofFloat(v, "rotation", 0.0F, -360.0F).setDuration(500).start();
    }
}
