package com.rajesh.retrofitsample.rest.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rajesh on 4/5/16.
 */
public class UserDetailsResponse {

    /*
    * Example response pojo class */

    @SerializedName("UserID")
    private String userID;

    @SerializedName("TokenID")
    private String tokenID;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTokenID() {
        return tokenID;
    }

    public void setTokenID(String tokenID) {
        this.tokenID = tokenID;
    }
}
