package com.codingblocks.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPhone, btnEmail, btnBrowser;
    EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBrowser = findViewById(R.id.btnBrowser);
        btnEmail = findViewById(R.id.btnEmail);
        btnPhone = findViewById(R.id.btnPhone);

        etInput = findViewById(R.id.etInput);

        btnBrowser.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnPhone.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String input = etInput.getText().toString();
        Intent intent = new Intent();

        switch (v.getId()) {
            case R.id.btnBrowser:
                //Start a browser based on the input
                if (!input.startsWith("http://") || !input.startsWith("https://")) {
                    input = "https://" + input;
                }
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(input));

                break;
            case R.id.btnEmail:
                //Open the email app
                intent.setAction(Intent.ACTION_SENDTO);
                if (!input.startsWith("mailto:")) {
                    input = "mailto:" + input;
                }
                intent.setData(Uri.parse(input));
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, "h@cb.lk");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Test");
                break;
            case R.id.btnPhone:
                //Open the phone app
                if (!input.startsWith("tel:")) {
                    input = "tel:" + input;
                }
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse(input));
                break;
        }

        startActivity(intent);

    }
}
