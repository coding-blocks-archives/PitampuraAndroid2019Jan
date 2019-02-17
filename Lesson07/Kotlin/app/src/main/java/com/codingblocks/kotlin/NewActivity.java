package com.codingblocks.kotlin;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Mango mango = new Mango("Sweet", "354353", "Delhi");
        String origin = mango.getOrigin();



        Float value;

        if (savedInstanceState != null){
            savedInstanceState.putFloat("KEY", 1F);
            value = savedInstanceState.getFloat("KEY");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


}
