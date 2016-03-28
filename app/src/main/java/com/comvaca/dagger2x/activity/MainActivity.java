package com.comvaca.dagger2x.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import com.comvaca.dagger2x.R;

import java.io.IOException;

public class MainActivity extends BaseActivity {

  private TextView tvTest;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    tvTest = (TextView) findViewById(R.id.tv_text);

    new AsyncTask<String, Void, String>() {
      @Override
      protected String doInBackground(String... params) {
        String s = null;
        try {
          s = getAPI(params[0]);
        } catch (IOException e) {
          e.printStackTrace();
        }
        return s;
      }

      @Override
      protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tvTest.setText(s);
      }
    }.execute("http://square.github.io/okhttp/");
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main, menu);
    return true;
  }
}
