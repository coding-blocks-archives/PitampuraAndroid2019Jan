package com.codingblocks.onclicklisteners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnIncrement, btnDecrement;
    TextView tvCount;
    Integer count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDecrement = findViewById(R.id.btnDecrement);
        btnIncrement = findViewById(R.id.btnIncrement);
        tvCount = findViewById(R.id.tvCount);

//        Fruit f = new Fruit() {
//            @Override
//            public String getOrigin() {
//                return null;
//            }
//
//            @Override
//            public String getTaste() {
//                return null;
//            }
//
//            @Override
//            public String getPrice() {
//                return null;
//            }
//        };

        //Can you create an instance of an interface? No

//        View.OnClickListener clickListener = new MyClickListener();

        tvCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                tvCount.setText(count.toString());
            }
        });

        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                //Perform the computation to increase the count
                tvCount.setText(count.toString());
            }
        });

        btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                //Perform the computation to decrease the count
                tvCount.setText(count.toString());
            }
        });

    }

    public void increment(View view) {

    }

    public void decrement(View view) {

    }
}
