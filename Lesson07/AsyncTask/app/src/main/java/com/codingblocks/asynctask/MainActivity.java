package com.codingblocks.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnStop;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        textView = findViewById(R.id.tvContent);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CountTask countTask = new CountTask();
                countTask.execute(1000000L);

                //blocks your main thread from doing any additional work!
//                for (long i = 0; i < 100000000L; i++) {
//                }


                //This is a non-UI thread
//                Thread t = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        for (long i = 0; i < 100000000L; i++) {
//                        }
//
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                textView.setText("Counting Done!");
//                            }
//                        });
//                    }
//                });
//
//                t.start();

                //
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

            }
        });


        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Timer Stopped", Toast.LENGTH_SHORT).show();

            }
        });
    }

    class CountTask extends AsyncTask<Long, Double, String> {

        //Runs on the Main Thread
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setText("Counting Started");
        }

        //Runs on the Background thread
        @Override
        protected String doInBackground(Long... longs) {

            Long countThreshold = longs[0];

//            Thread.sleep(countThreshold);

            for (int i = 0; i < countThreshold; i++) {

                if (i % 100000 == 0) {

                    publishProgress((double) i);

                }

            }
//            for (int i = 0; i < longs.length; i++) {
//
//                long currentCount = longs[i];
//
//            }
            return "Counting till " + countThreshold + " done";
        }

        //Runs on the Main Thread
        @Override
        protected void onProgressUpdate(Double... values) {
            super.onProgressUpdate(values);
            Double currentProgress = values[0];
            Toast.makeText(MainActivity.this,
                    "Count is : " + currentProgress,
                    Toast.LENGTH_SHORT).show();
        }

        //Runs on the Main Thread
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText(s);
        }
    }

}
