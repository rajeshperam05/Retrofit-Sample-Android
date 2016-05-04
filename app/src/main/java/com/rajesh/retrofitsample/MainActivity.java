package com.rajesh.retrofitsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.rajesh.retrofitsample.rest.request.UserDetails;
import com.rajesh.retrofitsample.rest.response.UserDetailsResponse;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String name;
    private UserDetails userDetails;
    private Button btnGet;
    private Button btnPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGet = (Button) findViewById(R.id.btnGet);
        btnPost = (Button) findViewById(R.id.btnPost);

        btnGet.setOnClickListener(this);
        btnPost.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnGet:

                // Get method by using retrofit and handle response.
                retrofitGetMethod();

                break;

            case R.id.btnPost:

                /*
                *  Post method by using retrofit and handle response.
                *  Sending userDetails pojo class as request body to post method by inserting details.
                *  Getting response with userDetailsResponse pojo class by direct conversion from
                *  Json to pojo class object by using Gson.*/
                retrofitPostMethod();

                break;
        }

    }

    private void retrofitGetMethod(){

        MainApplication.getInstance().getRetrofitServices().getMethod(name, new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {

                // Handle response
                Log.e("Retrofit", "Response: " + response.getBody());

            }

            @Override
            public void failure(RetrofitError error) {

                // Handle error

            }
        });
    }

    private void retrofitPostMethod(){

        // Insert details into request body.
        userDetails = new UserDetails();
        userDetails.setUserName("username");
        userDetails.setPassword("password");

        MainApplication.getInstance().getRetrofitServices().postMethod(userDetails, new Callback<UserDetailsResponse>() {
            @Override
            public void success(UserDetailsResponse userDetailsResponse, Response response) {

                // Handle response

                Log.e("Retrofit", "UserID: " + userDetailsResponse.getUserID());
                Log.e("Retrofit", "TokenID: " + userDetailsResponse.getTokenID());
            }

            @Override
            public void failure(RetrofitError error) {

                // Handle Error
            }
        });
    }


}
