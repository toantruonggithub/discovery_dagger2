package com.comvaca.dagger2x.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.comvaca.dagger2x.MyApplication;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import retrofit.Retrofit;

public class BaseActivity extends AppCompatActivity {

  protected final Context context = this;

  public static final MediaType JSON
      = MediaType.parse("application/json; charset=utf-8");

  @Inject
  OkHttpClient mOkHttpClient1;

  @Inject
  SharedPreferences sharedPreferences;

  @Inject
  Retrofit retrofit;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ((MyApplication) getApplication()).getGithubComponent().inject(this);
  }

  String postAPI(String url, String json) throws IOException {
    RequestBody body = RequestBody.create(JSON, json);
    Request request = new Request.Builder()
        .url(url)
        .post(body)
        .build();
    Response response = mOkHttpClient1.newCall(request).execute();
    return response.body().string();
  }

  String getAPI(String url) throws IOException {
    Request request = new Request.Builder()
        .url(url)
        .build();

    Response response = mOkHttpClient1.newCall(request).execute();
    return response.body().string();
  }
}
