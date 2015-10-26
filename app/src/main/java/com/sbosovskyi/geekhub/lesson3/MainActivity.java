package com.sbosovskyi.geekhub.lesson3;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import com.sbosovskyi.geekhub.lesson3.interfaces.CallbackForDifferentObjects;
import com.sbosovskyi.geekhub.lesson3.interfaces.MakeWorkInterface;

public class MainActivity extends BaseActivity implements MakeWorkInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void addFragment() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.fragment_container, new MainFragment()).commit();
    }


    @Override
    public void success(String result) {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragment_container, new SecondFragment()).commit();
    }

    @Override
    public void error() {

    }
}
