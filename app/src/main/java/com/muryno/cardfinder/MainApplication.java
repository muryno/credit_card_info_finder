package com.muryno.cardfinder;

import androidx.multidex.MultiDexApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;




public class MainApplication extends MultiDexApplication {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();
    private static MainApplication instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;



    }



    public static ExecutorService getExecutorService() {
        return executorService;
    }

    public static MainApplication getInstance() {
        return instance;
    }


}
