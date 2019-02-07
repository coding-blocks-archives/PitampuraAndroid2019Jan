package com.codingblocks.intentfilters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etUrl;
    Button btnNaviage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent = getIntent();
//
//        Uri url = intent.getData();

        //Navigate the user to this above url

        btnNaviage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = etUrl.getText().toString();
                Uri uri = Uri.parse(url);

                Intent intent = new Intent(getBaseContext(), BrowserActivity.class);
                intent.setData(uri);
                startActivity(intent);

            }
        });

    }
}
