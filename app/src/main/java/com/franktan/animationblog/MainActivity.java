package com.franktan.animationblog;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

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
        Class activityClass = null;
        switch (item.id){
            case 1:
                activityClass = ViewAnimationActivity.class;
                break;
            case 2:
                activityClass = PropertyAnimationActivity.class;
                break;
            case 3:
                activityClass = VectorAnimationActivity.class;
                break;
            case 4:
                activityClass = RecyclerViewAnimationActivity.class;
                break;
            default:
                break;
        }
        if(activityClass != null) {
            Intent intent = new Intent(this, activityClass);
            startActivity(intent);
        }
    }
}
