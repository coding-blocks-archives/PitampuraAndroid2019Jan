package com.codingblocks.onclicklisteners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnHello, btnSup;
    EditText etBye;
    Integer count;

//    String[] strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //This method sets the XML on the screen
        setContentView(R.layout.activity_main);
        btnHello = findViewById(R.id.btnHello);
        etBye = findViewById(R.id.etBye);
        btnSup = findViewById(R.id.buttonSup);

//        strings[1] = "Hello";

        btnHello.setOnClickListener(this);

//        etBye.setOnClickListener(this);

        btnSup.setOnClickListener(this);
    }

    public void increaseBy(Integer x) {
        count += x;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnHello:
                String etContent = etBye.getText().toString();
                Toast.makeText(this, etContent, Toast.LENGTH_SHORT).show();
                //Show a toast
                break;
            case R.id.buttonSup:
                //Show a toast
                break;
        }
    }
}
