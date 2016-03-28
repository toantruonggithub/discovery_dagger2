package com.comvaca.dagger2x.dagger.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

  Application mApplication;

  public AppModule(Application application) {
    mApplication = application;
  }

  @Provides
  @Singleton
  Application providesApplication() {
    return mApplication;
  }
}
