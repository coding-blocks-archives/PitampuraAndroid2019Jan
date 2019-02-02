package com.codingblocks.counter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final String TAG = getClass().getSimpleName();
    TextView countView;
    private Integer count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        countView = findViewById(R.id.textView);

        Log.e(TAG, "onCreate: ");
//        Log.v();
//        Log.i();
//        Log.w();


//        Student student = Student.getInstance("Harshit",
//                "Mayur Vihar");
//
//        Log.e("TAG", student.toString());
//
//        Student student2 = Student.getInstance("Harshit",
//                "New Delhi");
//
//        Log.e("TAG", student2.toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    // Your app is in running state

    @Override
    protected void onPause() {
        //Called when your activity is partially hidden
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        //Called when your activity is fully hidden/no longer visible
        super.onStop();
        Log.e(TAG, "onStop: ");

    }

    @Override
    protected void onRestart() {
        //Called when your app is restarted after it was stopped(but not destroyed) by pressing the home button
        super.onRestart();
        Log.e(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        //Not called always, but is called when the activity is destroyed explicitly
        //or when the back button is pressed or when the OS decides to kill an app that was stopped to free up
        //more RAM
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }


    public void decrement(View view) {
        count--;

        //Write some code that gives me access to the TextView
        //Update the TextView with the value of count
        countView.setText(count.toString());

        Log.e(TAG, "decrement: " + count);
    }

    public void increment(View view) {
        count++;

        //Write some code that gives me access to the TextView
        //Update the TextView with the value of count
        countView.setText(count.toString());

        Log.e(TAG, "increment: " + count);
    }
}
