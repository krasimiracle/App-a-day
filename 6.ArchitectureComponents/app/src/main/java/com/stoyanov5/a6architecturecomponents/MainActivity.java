package com.stoyanov5.a6architecturecomponents;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

/**
 * Created by B3f0r on 12-Mar-18.
 */

public class MainActivity extends AppCompatActivity {


    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private int position = RecyclerView.NO_POSITION;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        progressBar = findViewById(R.id.pb_loading_indicator);

        recyclerView = findViewById(R.id.recyclerview_forecast);
        recyclerView.setHasFixedSize(true);


    }
}
