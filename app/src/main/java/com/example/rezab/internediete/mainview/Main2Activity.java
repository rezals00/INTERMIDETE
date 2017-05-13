package com.example.rezab.internediete.mainview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.rezab.internediete.R;

public class Main2Activity extends AppCompatActivity {
    private TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        setTitle("Selamat Datang "+i.getStringExtra("username"));
        text1 = (TextView) findViewById(R.id.textView);
        text1.setText(i.getStringExtra("username"));
    }
}
