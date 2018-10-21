package com.example.mypracticeasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        new ProgressAsyncTask((ProgressBar) findViewById(R.id.progressBar), (TextView) findViewById(R.id.status), (TextView) findViewById(R.id.count)).execute();
    }
}
