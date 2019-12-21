package com.franktan.animationblog;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PropertyAnimationActivity extends AppCompatActivity {
    private LinearLayout mAnimationLayout;
    private ImageView mImageView;
    private Animator mRunningAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);

        mAnimationLayout = (LinearLayout) findViewById(R.id.animation_layout);
        mImageView = (ImageView) findViewById(R.id.image);
    }

    public void onAddItemButtonClicked(View view) {
        TextView textView = new TextView(this);
        textView.setText("Item");
        mAnimationLayout.addView(textView);
    }

    public void onFadeObjAnimButtonClicked(View view) {
        if(mRunningAnimator != null && mRunningAnimator.isRunning()) {
            mRunningAnimator.end();
        }
        mRunningAnimator = null;
        // With object animator, it call setAlpha automatically when the value is calculated
        // The animated object must have a public set<PropertyName> method
        ObjectAnimator animator = ObjectAnimator.ofFloat(mImageView, "alpha", 1f, 0f);
        animator.setDuration(600);
        animator.setRepeatCount(1);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        mRunningAnimator = animator;
        animator.start();
    }

    public void onFadeValueAnimButtonClicked(View view) {
        if(mRunningAnimator != null && mRunningAnimator.isRunning()) {
            mRunningAnimator.end();
        }
        mRunningAnimator = null;
        // With value animator, it does not update the value automatically
        // It is suitable for object without a set<PropertyName> method
        // The example here is for demonstration only
        ValueAnimator animator = ValueAnimator.ofFloat(1f, 0f);
        animator.setDuration(600);
        animator.setRepeatCount(1);
        animator.setRepeatMode(ValueAnimator.REVERSE);

        // We must explicitly listen to update event and set the value
        animator.removeAllUpdateListeners();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float alpha = (float) animation.getAnimatedValue();
                mImageView.setAlpha(alpha);
            }
        });
        mRunningAnimator = animator;
        animator.start();
    }

    public void onFlipButtonClicked(View view) {
        if(mRunningAnimator != null && mRunningAnimator.isRunning()) {
            mRunningAnimator.end();
        }
        mRunningAnimator = null;
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.flip);
        animator.setTarget(mImageView);
        mRunningAnimator = animator;
        animator.start();
    }

    public void onAnimSetButtonClicked(View view) {
        if(mRunningAnimator != null && mRunningAnimator.isRunning()) {
            mRunningAnimator.end();
        }
        mRunningAnimator = null;
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,
                R.animator.scale_rotate);
        set.setTarget(mImageView);
        mRunningAnimator = set;
        set.start();
    }

    public void onViewPropertyAnimatorButtonClicked(View view) {
        mImageView.animate()
                .setDuration(500)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .scaleX(.5f)
                .scaleY(.5f)
                .alpha(.5f)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        mImageView.animate()
                                .setDuration(500)
                                .setInterpolator(new AccelerateDecelerateInterpolator())
                                .scaleX(1f)
                                .scaleY(1f)
                                .alpha(1f)
                                .start();
                    }
                })
                .start();
    }
}
