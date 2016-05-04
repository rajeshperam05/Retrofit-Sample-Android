package com.rajesh.retrofitsample.rest;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rajesh.retrofitsample.services.RetrofitServices;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by ramya on 23/12/15.
 */
public class RestClient {

    private static final String BASE_URL = "http://000.000.8080/retrofit/api"; // replace with your url

    private RetrofitServices retrofitServices; // Services interface


    /*
    * We can use Gson in retrofit to convert Json response directly in java pojo class.
    * Build RestAdapter with endpoint url and Gson converter.
    * Headers are common to every request*/
    public RestClient() {

        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new ItemTypeAdapterFactory())
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .setConverter(new GsonConverter(gson))
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {    // Headers
                        request.addHeader("Content-Type", "application/json");
                        request.addHeader("Accept", "application/json");
                        request.addHeader("Accept-Language", "en-gb");
                    }
                })
                .build();

        retrofitServices = restAdapter.create(RetrofitServices.class);

    }


    public RetrofitServices getRetrofitServices() {
        return retrofitServices;
    }

}
