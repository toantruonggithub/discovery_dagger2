package com.comvaca.dagger2x;

import android.app.Application;

import com.comvaca.dagger2x.dagger.components.DaggerGithubComponent;
import com.comvaca.dagger2x.dagger.components.DaggerNetComponent;
import com.comvaca.dagger2x.dagger.components.GithubComponent;
import com.comvaca.dagger2x.dagger.components.NetComponent;
import com.comvaca.dagger2x.dagger.modules.AppModule;
import com.comvaca.dagger2x.dagger.modules.GithubModule;
import com.comvaca.dagger2x.dagger.modules.NetModule;


public class MyApplication extends Application {

  private NetComponent mNetComponent;
  private GithubComponent mGithubComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    mNetComponent = DaggerNetComponent.builder().appModule(new AppModule(this)).netModule(new NetModule("https://api.github.com")).build();
    mGithubComponent = DaggerGithubComponent.builder().netComponent(mNetComponent).githubModule(new GithubModule()).build();
  }

  public NetComponent getNetComponent() {
    return mNetComponent;
  }

  public GithubComponent getGithubComponent() {
    return mGithubComponent;
  }
}
