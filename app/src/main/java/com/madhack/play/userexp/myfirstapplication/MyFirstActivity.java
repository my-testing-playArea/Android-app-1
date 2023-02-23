package com.madhack.play.userexp.myfirstapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MyFirstActivity extends Activity {
    static String LOG_TAG = "MyFirstActivity";

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


            new Thread(new Runnable() {
                @Override
                public void run() {
                    OkHttpClient client = new OkHttpClient();

                    RequestBody body = new FormBody.Builder()
                            .add("q", text)
                            .add("target", "zh-CN")
                            .add("source", "en")
                            .build();

                    Request request = new Request.Builder()
                            .url("https://google-translate1.p.rapidapi.com/language/translate/v2")
                            .post(body)
                            .addHeader("content-type", "application/x-www-form-urlencoded")
                            .addHeader("Accept-Encoding", "application/gzip")
                            .addHeader("X-RapidAPI-Key", "2f6e2a573emsh26b7a255e722e89p18f559jsn9cb644f9ae21")
                            .addHeader("X-RapidAPI-Host", "google-translate1.p.rapidapi.com")
                            .build();

                    try {
                        Response response = client.newCall(request).execute();
                        String responseText = response.body().string();
                        Log.i(LOG_TAG, responseText);
                        JSONObject responseJson = new JSONObject(responseText);
                        JSONObject data = responseJson.getJSONObject("data");
                        JSONArray translations = data.getJSONArray("translations");
                        JSONObject translation = translations.getJSONObject(0);
                        String translatedText = translation.getString("translatedText");

                        Log.i("translatedText", translatedText);


                        new Handler().post(new Runnable() {
                            @Override
                            public void run() {
                                tvTranslatedText.setText(translatedText);
                            }
                        });

                    } catch (IOException | JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();

        });


    }

}
