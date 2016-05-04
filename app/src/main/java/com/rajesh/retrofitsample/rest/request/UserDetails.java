package com.rajesh.retrofitsample.rest.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rajesh on 4/5/16.
 */
public class UserDetails {

    /*
    * Example pojo or model class */

    @SerializedName("UserName")
    private String userName;

    @SerializedName("Password")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
