package com.orion.githubrxjava;

public interface IBasePresenter<T extends IBaseView> {
    void onCreate();
    void onStart();
    void onStop();
    void onPause();
    void attachView(T view);
}