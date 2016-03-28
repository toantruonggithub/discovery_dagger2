package com.comvaca.dagger2x.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;
import android.widget.Toast;

import com.comvaca.dagger2x.R;
import com.comvaca.dagger2x.models.Repository;
import com.comvaca.dagger2x.network.GithubApi;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

  private TextView tvTest;

  private GithubApi githubApi;

  private final String user = "toantruonggithub";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    tvTest = (TextView) findViewById(R.id.tv_text);

    githubApi = new GithubApi(retrofit);

    githubApi.getRepos(user, new GithubApi.ResponseHandler() {
      @Override
      public void onResponse(Object data) {
        Toast.makeText(context, "Result OK", Toast.LENGTH_SHORT).show();
        ArrayList<Repository> repositories = (ArrayList<Repository>) data;
        for (Repository repository : repositories) {
          tvTest.append("\n" + repository.getName());
          tvTest.append("\n" + repository.getFullName());
          tvTest.append("\n" + repository.getDescription());
          tvTest.append("\n------------------------\n");
        }
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
