package com.comvaca.dagger2x.dagger.components;

import android.content.SharedPreferences;

import com.comvaca.dagger2x.activity.BaseActivity;
import com.comvaca.dagger2x.dagger.modules.AppModule;
import com.comvaca.dagger2x.dagger.modules.NetModule;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Component;
import retrofit.Retrofit;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
  Retrofit retrofit();
  OkHttpClient okHttpClient();
  SharedPreferences sharedPreferences();
}
