package com.example.user.mvpwithdaggermyexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import rx.Observer;
import rx.subjects.PublishSubject;

public class BaseApp extends AppCompatActivity {

    private static final String TAG = BaseApp.class.getSimpleName();
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_details);
    }
    private void doSomeWork() {

        PublishSubject<Integer> source = PublishSubject.create();

        source.subscribe(getFirstObserver()); // it will get 1, 2, 3, 4 and onComplete

        source.onNext(1);
        source.onNext(2);
        source.onNext(3);

        source.subscribe(getSecondObserver());

        source.onNext(4);
        source.onCompleted();
    }

    private Observer<Integer> getFirstObserver() {
        return new Observer<Integer>() {
            @Override
            public void onNext(Integer value) {
                textView.append(" First onNext : value : " + value);
                Log.d(TAG, " First onNext value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                textView.append(" First onError : " + e.getMessage());
                Log.d(TAG, " First onError : " + e.getMessage());
            }

            @Override
            public void onCompleted() {
                textView.append(" First onComplete");
                Log.d(TAG, " First onComplete");
            }
        };
    }

    private Observer<Integer> getSecondObserver() {
        return new Observer<Integer>() {
            @Override
            public void onNext(Integer value) {
                textView.append(" Second onNext : value : " + value);
                Log.d(TAG, " Second onNext value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                textView.append(" Second onError : " + e.getMessage());
                Log.d(TAG, " Second onError : " + e.getMessage());
            }

            @Override
            public void onCompleted() {
                textView.append(" Second onComplete");
                Log.d(TAG, " Second onComplete");
            }
        };
    }
}





