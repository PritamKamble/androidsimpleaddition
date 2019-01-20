package com.example.pritam.simplecalculator;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class progressActivity extends AppCompatActivity {

    private ProgressBar pbhorizontal;
    private ProgressBar pbcircle;

    private int progressStatus = 0;
    private TextView textViewForHorizontal;
    private TextView textViewForCircle;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        pbcircle=findViewById(R.id.progressBar3);
        pbhorizontal=findViewById(R.id.progressBar1);

        textViewForHorizontal=findViewById(R.id.textView);
        textViewForCircle=findViewById(R.id.textView2);



        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    if(progressStatus==99)
                    {
                        Intent i = new Intent(progressActivity.this, resultActivity.class);

                        String s1=getIntent().getStringExtra("result");

                        i.putExtra("result",s1);
                        startActivity(i);
                    }
                    {
                        handler.post(new Runnable() {
                            public void run() {
                                pbhorizontal.setProgress(progressStatus);
                                pbcircle.setProgress(progressStatus);
                                textViewForHorizontal.setText(progressStatus + "/" + pbhorizontal.getMax());
                                textViewForCircle.setText(progressStatus + "/" + pbcircle.getMax());


                            }});
                        try {
                            // Sleep for 200 milliseconds.
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }).start();

    }
}
