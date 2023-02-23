package com.madhack.play.userexp.myfirstapplication;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class MyUILayoutActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_first_ui);
    }
}
