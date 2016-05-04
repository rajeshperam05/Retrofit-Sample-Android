package com.rajesh.retrofitsample;

import android.app.Application;
import android.util.Log;

import com.rajesh.retrofitsample.rest.RestClient;

/**
 * Created by rajesh on 4/5/16.
 */
public class MainApplication extends Application{

    private static RestClient restClient;

    @Override
    public void onCreate() {
        super.onCreate();

        restClient = new RestClient(); // Making Retrofit single instance

        Log.e("test", "tesjgalsd");
    }


    public static RestClient getInstance(){
        return restClient;
    }
}
