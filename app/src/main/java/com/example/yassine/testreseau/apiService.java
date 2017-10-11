package com.example.yassine.testreseau;

import com.example.yassine.testreseau.models.Users;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Yassine on 11/10/2017.
 */

public interface apiService {
    @GET("/fichier_json.json")
    void getUsers(Callback<Users> callback);



}
