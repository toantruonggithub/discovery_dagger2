package com.comvaca.dagger2x;

import android.app.Application;

import com.comvaca.dagger2x.dagger.components.DaggerNetComponent;
import com.comvaca.dagger2x.dagger.components.NetComponent;
import com.comvaca.dagger2x.dagger.modules.AppModule;
import com.comvaca.dagger2x.dagger.modules.NetModule;


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
