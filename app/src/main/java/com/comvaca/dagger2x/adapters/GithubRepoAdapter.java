package com.comvaca.dagger2x.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.comvaca.dagger2x.R;
import com.comvaca.dagger2x.models.Repository;

import java.util.List;

public class GithubRepoAdapter extends BaseAdapter {

  private List<Repository> repositories;
  private Context context;
  private LayoutInflater inflater;

  public GithubRepoAdapter(Context context, List<Repository> repositories) {
    this.repositories = repositories;
    this.context = context;
    this.inflater = LayoutInflater.from(context);
  }

  @Override
  public int getCount() {
    return repositories.size();
  }

  @Override
  public Object getItem(int position) {
    return repositories.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    RepoHolder holder;
    if (convertView == null) {
      convertView = inflater.inflate(R.layout.item_repos, parent, false);
      holder = new RepoHolder(convertView);
      convertView.setTag(holder);
    } else {
      holder = (RepoHolder) convertView.getTag();
    }

    Repository repository = (Repository) getItem(position);

    holder.tvName.setText(repository.getName());
    holder.tvUrl.setText(repository.getSshUrl());
    holder.tvTime.setText(repository.getCreateAt());

    return convertView;
  }

  class RepoHolder {
    public TextView tvName;
    public TextView tvUrl;
    public TextView tvTime;

    public RepoHolder(View v) {
      tvName = (TextView) v.findViewById(R.id.tv_name);
      tvUrl = (TextView) v.findViewById(R.id.tv_url);
      tvTime = (TextView) v.findViewById(R.id.tv_time);
    }
  }
}
