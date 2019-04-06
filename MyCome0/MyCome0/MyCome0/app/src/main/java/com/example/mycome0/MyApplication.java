package com.example.mycome0;

//import android.app.Application;

public class MyApplication extends android.app.Application {

    User user;

    @Override
    public void onCreate() {
        super.onCreate();
        user = new User();
    }
}
