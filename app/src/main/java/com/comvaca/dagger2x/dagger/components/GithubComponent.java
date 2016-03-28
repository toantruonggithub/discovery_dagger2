package com.comvaca.dagger2x.dagger.components;

import com.comvaca.dagger2x.activity.BaseActivity;
import com.comvaca.dagger2x.dagger.modules.GithubModule;
import com.comvaca.dagger2x.dagger.scopes.UserScope;

import dagger.Component;

@UserScope
@Component(dependencies = NetComponent.class, modules = GithubModule.class)
public interface GithubComponent {
    void inject(BaseActivity activity);
}
