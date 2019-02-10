package com.codingblocks.intentfilters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUrl;
    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUrl = findViewById(R.id.etUrl);
        btnGo = findViewById(R.id.btnGo);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent  intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.setData(null);

                Intent i = new Intent(getBaseContext(), BrowserActivity.class);

//                Log.e("TAG", "onClick: Action is : " + i.getAction());

                String url = etUrl.getText().toString();
                i.setData(Uri.parse(url));

//                i.putExtra("EXPLICIT_INTENT_URL", url);
                startActivity(i);

            }
        });


//        Intent intent = getIntent();
//
//        Uri url = intent.getData();

        //Navigate the user to this above url

    }
}
