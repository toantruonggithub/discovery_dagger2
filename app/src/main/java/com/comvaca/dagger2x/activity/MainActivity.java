package com.comvaca.dagger2x.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.comvaca.dagger2x.R;
import com.comvaca.dagger2x.adapters.GithubRepoAdapter;
import com.comvaca.dagger2x.models.Repository;
import com.comvaca.dagger2x.network.GithubApi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends BaseActivity {

  private ListView listRepos;

  private GithubApi githubApi;

  private final String user = "toantruonggithub";

  private List<Repository> repositories;
  private GithubRepoAdapter repoAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    listRepos = (ListView) findViewById(R.id.list_repos);

    githubApi = new GithubApi(retrofit);

    repositories = new ArrayList<>();

    repoAdapter = new GithubRepoAdapter(context, repositories);
    listRepos.setAdapter(repoAdapter);

    githubApi.getRepos(user, new GithubApi.ResponseHandler() {
      @Override
      public void onResponse(Object data) {
        repositories.clear();
        repositories.addAll((ArrayList<Repository>) data);
        repoAdapter.notifyDataSetChanged();
      }

      @Override
      public void onFailure() {
        Toast.makeText(context, "Result Failed", Toast.LENGTH_SHORT).show();
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main, menu);
    return true;
  }
}
