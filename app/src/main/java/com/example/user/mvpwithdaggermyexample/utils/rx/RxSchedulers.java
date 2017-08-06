package com.example.user.mvpwithdaggermyexample.utils.rx;

import rx.Scheduler;

/**
 * Created by user on 12/07/2017.
 */

public interface RxSchedulers {

    Scheduler runOnBackground();

    Scheduler io();

    Scheduler compute();

    Scheduler androidThread();

    Scheduler internet();

}
