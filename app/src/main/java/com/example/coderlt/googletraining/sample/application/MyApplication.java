package com.example.coderlt.googletraining.sample.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by coderlt on 2018/2/23.
 */

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate(){
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }
}
