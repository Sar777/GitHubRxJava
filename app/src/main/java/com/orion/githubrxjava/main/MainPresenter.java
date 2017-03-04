package com.orion.githubrxjava.main;

import com.orion.githubrxjava.IBasePresenter;
import com.orion.githubrxjava.models.Repository;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainPresenter implements IBasePresenter<IMainView> {
    private MainModel mModel;
    private IMainView mView;

    Subscription mSubscription;

    public MainPresenter() {
        this.mModel = new MainModelImpl();
    }

    @Override
    public void onCreate() {
        mView.hideProgress();
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onPause() {
        this.mView = null;

        if (mSubscription != null && mSubscription.isUnsubscribed())
            mSubscription.unsubscribe();
    }

    @Override
    public void attachView(IMainView view) {
        this.mView = view;
    }

    public void onLoadRepositories(String username) {
        if (mView == null)
            return;

        mView.hideLoadButton();
        mView.showProgress();

        if (mSubscription != null && mSubscription.isUnsubscribed())
            mSubscription.unsubscribe();

        mSubscription = mModel.getRepositoryList(username)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Repository>>() {
                    @Override
                    public void onCompleted() {
                        if (mView != null)
                            mView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (mView != null) {
                            mView.hideProgress();
                            mView.showLoadButton();
                        }
                    }

                    @Override
                    public void onNext(List<Repository> repositories) {
                        if (mView != null)
                            mView.setRepositories(repositories);
                    }
                });
    }
}
