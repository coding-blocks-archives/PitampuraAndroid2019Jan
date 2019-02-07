package com.codingblocks.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnStartIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartIntent = findViewById(R.id.btnStartIntent);

//        Toast.makeText(this, "Toast", Toast.LENGTH_SHORT).show();

        btnStartIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Start the new Activity

                //1. Create an object of the Intent class
                //2. Start that object

                Intent i = new Intent(getBaseContext(), NewActivity.class);

                i.putExtra("COUNT", 4);
                i.putExtra("NAME", "Harshit");
                i.putExtra("ADDRESS", "Delhi");
                i.putExtra("BATCH", "Android");
                i.putExtra("ISCOOL", true);
//
//                String path = i.getComponent().getPackageName() + "/" +
//                        i.getComponent().getPackageName() + "." +
//                        i.getComponent().getClassName();

                startActivity(i);
            }
        });
    }
}
