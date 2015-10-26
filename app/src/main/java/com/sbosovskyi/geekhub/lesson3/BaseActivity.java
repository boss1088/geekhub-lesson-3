package com.sbosovskyi.geekhub.lesson3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by boss1088 on 10/26/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContent();

        if (savedInstanceState == null) {
            addFragment();
        }
    }

    public void setContent() {
        setContentView(R.layout.activity_base);
    }

    public abstract void addFragment();
}
