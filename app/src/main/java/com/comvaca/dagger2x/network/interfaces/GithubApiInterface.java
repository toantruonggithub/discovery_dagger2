package com.comvaca.dagger2x.network.interfaces;

import com.comvaca.dagger2x.models.Repository;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Part;

public interface GithubApiInterface {

    @GET("users/toantruonggithub/repos")
    Call<ArrayList<Repository>> getUserRepositories();

}
