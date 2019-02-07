package com.codingblocks.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        int count = intent.getIntExtra("COUNT",0);

        Log.e("TAG", "onCreate: " + "Name : " + name + " Count : " + count);

    }
}
