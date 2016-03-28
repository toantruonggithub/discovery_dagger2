package com.comvaca.dagger2x;

import android.app.Application;

import com.comvaca.dagger2x.dagger.AppModule;
import com.comvaca.dagger2x.dagger.DaggerNetComponent;
import com.comvaca.dagger2x.dagger.NetComponent;
import com.comvaca.dagger2x.dagger.NetModule;

public class MyApplication extends Application {

  private NetComponent mNetComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    mNetComponent = DaggerNetComponent.builder().appModule(new AppModule(this)).netModule(new NetModule("https://api.github.com")).build();
  }

  public NetComponent getNetComponent() {
    return mNetComponent;
  }
}
