package com.comvaca.dagger2x.dagger.modules;

import com.comvaca.dagger2x.dagger.scopes.UserScope;
import com.comvaca.dagger2x.network.interfaces.GithubApiInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

@Module
public class GithubModule {

    @Provides
    @UserScope
    GithubApiInterface providesGithubApiInterface(Retrofit retrofit) {
        return retrofit.create(GithubApiInterface.class);
    }
}
