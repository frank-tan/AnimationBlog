package com.franktan.animationblog;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class VectorAnimationActivity extends AppCompatActivity {
    private FloatingActionButton mFab;
    private ImageView mLikeButton;
    private boolean isTick = true;
    private boolean like = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_animation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mLikeButton = (ImageView) findViewById(R.id.like_button);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    AnimatedVectorDrawable tickToCross;
                    AnimatedVectorDrawable crossToTick;
                    tickToCross = (AnimatedVectorDrawable) getDrawable(R.drawable.tick_to_cross);
                    crossToTick = (AnimatedVectorDrawable) getDrawable(R.drawable.cross_to_tick);

                    AnimatedVectorDrawable animDrawable = isTick ? tickToCross: crossToTick;
                    mFab.setImageDrawable(animDrawable);
                    animDrawable.start();
                } else {
                    int drawableId = isTick ? R.drawable.cross : R.drawable.tick;
                    mFab.setImageResource(drawableId);
                }
                isTick = !isTick;
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onLikeButtonClicked(View view) {
        if(Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            AnimatedVectorDrawable fillHeart;
            AnimatedVectorDrawable emptyHeart;
            fillHeart = (AnimatedVectorDrawable) getDrawable(R.drawable.fill_heart);
            emptyHeart = (AnimatedVectorDrawable) getDrawable(R.drawable.empty_heart);

            AnimatedVectorDrawable animDrawable = like ? emptyHeart : fillHeart;
            mLikeButton.setImageDrawable(animDrawable);
            animDrawable.start();
        } else {
            int nextDrawableId = like ? R.drawable.ic_heart_empty : R.drawable.ic_heart_filled;
            mLikeButton.setImageResource(nextDrawableId);
        }
        like = !like;
    }
}
