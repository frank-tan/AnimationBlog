package com.franktan.animationblog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.franktan.animationblog.activitylist.ActivityEntryFactory;
import com.franktan.animationblog.activitylist.EntryFragment;

public class MainActivity extends AppCompatActivity implements EntryFragment.OnEntryListItemClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onEntryListItemClicked(ActivityEntryFactory.ActivityEntry item) {
        Intent intent = new Intent(this,ViewAnimationActivity.class);
        startActivity(intent);
    }
}
