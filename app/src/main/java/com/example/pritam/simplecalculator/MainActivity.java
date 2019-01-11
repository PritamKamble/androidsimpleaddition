package com.example.pritam.simplecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText num1,num2;
    Button addition;
    TextView setans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText)findViewById(R.id.no1);
        num2 = (EditText)findViewById(R.id.no2);
        addition=(Button)findViewById(R.id.add);
        setans = (TextView)findViewById(R.id.ans);

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int n1=Integer.parseInt(num1.getText().toString());
                int n2=Integer.parseInt(num2.getText().toString());
                String ans=Integer.toString(n1+n2);
                setans.setText(ans);
                Intent i=new Intent(MainActivity.this,resultActivity.class);
                i.putExtra("result",ans);
            }
        });

    }
}
