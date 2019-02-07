package com.codingblocks.intentfilters;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class BrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //1. From the MainActivity
        //2. From any other app

        Intent callingIntent = getIntent();
        Uri uri = callingIntent.getData();


        //Load this URI into a WebView

    }
}
