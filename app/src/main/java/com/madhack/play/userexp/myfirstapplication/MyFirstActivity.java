package com.madhack.play.userexp.myfirstapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyFirstActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_first_layout);

        Button btnTranslate = findViewById(R.id.btn_translate);
        TextView tvTranslatedText = findViewById(R.id.my_layout_text_view);
        EditText etInputText = findViewById(R.id.my_layout_et_text);

        btnTranslate.setText("Translate");
        btnTranslate.setOnClickListener(v -> {
            String text = etInputText.getText().toString();

            tvTranslatedText.setText(text);

        });


    }

}
