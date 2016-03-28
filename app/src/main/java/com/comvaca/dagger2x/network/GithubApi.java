package com.comvaca.dagger2x.network;

import com.comvaca.dagger2x.models.Repository;
import com.comvaca.dagger2x.network.interfaces.GithubApiInterface;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class GithubApi {

    Retrofit mRetrofit;
    GithubApiInterface mGithubApiInterface;

    public interface ResponseHandler {
        public void onResponse(Object data);
        public void onFailure();
    }

    public GithubApi(Retrofit retrofit) {
        mRetrofit = retrofit;
        mGithubApiInterface = retrofit.create(GithubApiInterface.class);
    }

    public void getRepos(String username, final ResponseHandler responseHandler) {
        Call<ArrayList<Repository>> call = mGithubApiInterface.getUserRepositories();

        call.enqueue(new Callback<ArrayList<Repository>>() {
            @Override
            public void onResponse(Response<ArrayList<Repository>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    responseHandler.onResponse(response.body());
                } else {
                    responseHandler.onFailure();
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
