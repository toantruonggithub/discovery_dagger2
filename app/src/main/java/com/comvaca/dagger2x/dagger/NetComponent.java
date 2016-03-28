package com.comvaca.dagger2x.dagger;

import com.comvaca.dagger2x.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
  void inject(BaseActivity activity);
  // void inject(MyFragment fragment);
  // void inject(MyService service);
}
