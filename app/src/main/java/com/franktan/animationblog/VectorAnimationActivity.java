package com.franktan.animationblog;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class VectorAnimationActivity extends AppCompatActivity {
    private FloatingActionButton mFab;
    private AnimatedVectorDrawable tickToCross;
    private AnimatedVectorDrawable crossToTick;
    private boolean isTick = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_animation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            tickToCross = (AnimatedVectorDrawable) getDrawable(R.drawable.tick_to_cross);
            crossToTick = (AnimatedVectorDrawable) getDrawable(R.drawable.cross_to_tick);
        }

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
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

    public void onLickButtonClicked(View view) {

    }
}
