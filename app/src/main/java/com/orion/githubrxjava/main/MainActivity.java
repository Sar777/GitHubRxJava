package com.orion.githubrxjava.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.orion.githubrxjava.R;
import com.orion.githubrxjava.adapters.RepositoryListAdapter;
import com.orion.githubrxjava.models.Repository;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView, View.OnClickListener {

    private MainPresenter mPresenter;

    // View
    private ProgressBar mProgressBar;
    private Button mButton;
    private RecyclerView mRecyclerView;
    private RepositoryListAdapter mRepositoryListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
        mPresenter.onCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onPause() {
        mPresenter.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        mPresenter.onStop();
        super.onStop();
    }

    private void initView() {
        mButton = (Button) findViewById(R.id.btn_load_repositories);
        mButton.setOnClickListener(this);

        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        mRepositoryListAdapter = new RepositoryListAdapter(this);
        mRecyclerView.setAdapter(mRepositoryListAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showLoadButton() {
        mButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadButton() {
        mButton.setVisibility(View.GONE);
    }

    @Override
    public void setRepositories(List<Repository> repositories) {
        mRepositoryListAdapter.setResource(repositories);
        mRepositoryListAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(MainPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onClick(View v) {
        mPresenter.onLoadRepositories("Sar777");
    }
}
