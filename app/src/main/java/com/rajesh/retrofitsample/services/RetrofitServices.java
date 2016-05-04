package com.rajesh.retrofitsample.services;

import com.rajesh.retrofitsample.rest.request.UserDetails;
import com.rajesh.retrofitsample.rest.response.UserDetailsResponse;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by rajesh on 4/5/16.
 */
public interface RetrofitServices {

    @GET("/example.mobi/{Name}") // Extension for BASE URL
    void getMethod(@Path("Name") String e_mail, Callback<Response> userCallback);

    @POST("/example.mobi/")
    void postMethod(@Body UserDetails userDetails, Callback<UserDetailsResponse> userDetailsResponseCallback);
}
