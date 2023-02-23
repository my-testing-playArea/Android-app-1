package com.madhack.play.userexp.myfirstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MyFirstActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_first_layout);

        Button btn = findViewById(R.id.btnMyFirstButton);
        btn.setText("My First Button");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("MyFirstActivity","Button Clicked!");
            }
        });
    }

}
