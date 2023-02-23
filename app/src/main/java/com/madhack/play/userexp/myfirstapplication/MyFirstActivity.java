package com.madhack.play.userexp.myfirstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                Log.i("MyFirstActivity", "Button Clicked!");
            }
        });

        final TextView textView = findViewById(R.id.my_layout_text_view);
        textView.setText("Enter your text...");

        findViewById(R.id.button).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("MyFirstActivity", "Hello World");
                    }
                }
        );
    }

}
