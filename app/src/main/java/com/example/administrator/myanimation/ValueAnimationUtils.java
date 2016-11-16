package com.example.administrator.myanimation;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

/**
 * Created by Administrator on 2016/11/11.
 */
public class ValueAnimationUtils {
    public static void valueAnim(final View view) {
        int x = view.getHeight()*2;
        ValueAnimator animator = ValueAnimator.ofFloat(-x,x);
        animator.setDuration(100);
        animator.setTarget(view);
        //设置加速器减速器之类的，可以改变动画执行的速度
        animator.setInterpolator( new AccelerateInterpolator(2));
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                view.setTranslationX((Float) animation.getAnimatedValue());
            }
        });
    }
}
