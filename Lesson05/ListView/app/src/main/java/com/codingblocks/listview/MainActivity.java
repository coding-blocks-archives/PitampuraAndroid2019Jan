package com.codingblocks.listview;

import android.support.annotation.IdRes;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayout rootLayout;
    ListView lv;
    ArrayList<String> strings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        rootLayout = findViewById(R.id.rootLayout);
        lv = findViewById(R.id.listView);

        strings.add("Harshit");
        strings.add("Arnav");
        strings.add("Swastika");
        strings.add("Abhay");
        strings.add("Saumya");
        strings.add("Sir Dheeraj");
        strings.add("Raghav");
        strings.add("Malika");
        strings.add("Abhinav");
        strings.add("Rohit");
        strings.add("Arpit");
        strings.add("Rakshit");
        strings.add("Ankit");
        strings.add("Lavanya");
        strings.add("Keshav");
        strings.add("Akshay");
        strings.add("Shashikant");
        strings.add("Sahil");
        strings.add("Anuj");
        strings.add("Samarth");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.item_row,
                R.id.tvName,
                strings);

        lv.setAdapter(arrayAdapter);

//        for (int i =0 ; i< 100; i++){
//
//        }
//
//        btnAddd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                //Add the new button here
//
////                Button newButton = new Button(getBaseContext());
////
////                newButton.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
////                        ViewGroup.LayoutParams.WRAP_CONTENT));
////
////                newButton.setText("New Button");
//
////                rootLayout.addView(newButton);
//
////                View inflatedView = getLayoutInflater().inflate(R.layout.item_new_row,root,false);
//                  root.addView(inflatedView);
//
//            }
//        });

    }

}
