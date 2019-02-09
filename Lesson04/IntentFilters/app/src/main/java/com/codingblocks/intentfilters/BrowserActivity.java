package com.codingblocks.intentfilters;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class BrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //1. From the MainActivity
        //2. From any other app

        Intent callingIntent = getIntent();
        String url;

//        if (callingIntent.hasExtra("EXPLICIT_INTENT_URL")) {
//            url = callingIntent.getStringExtra("EXPLICIT_INTENT_URL");
//        } else {
//            url = callingIntent.getData().toString();
//        }
        Uri uri = callingIntent.getData();
        url = uri.toString();

        Log.e("TAG", "onCreate: The URL is : " + url);


        //Load this URI into a WebView

    }
}
