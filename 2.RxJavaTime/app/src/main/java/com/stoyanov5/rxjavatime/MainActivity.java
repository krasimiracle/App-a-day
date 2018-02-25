package com.stoyanov5.rxjavatime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Observable;
import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private Button observeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        observeButton = findViewById(R.id.button);

        observeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runSchedulerOnButtonClicked();
            }
        });
    }

    void runSchedulerOnButtonClicked() {
        Disposable observable = Flowable.interval(1, TimeUnit.SECONDS).map(v -> (v % 30) + 1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> textView.setText(result.toString()));
    }
}
