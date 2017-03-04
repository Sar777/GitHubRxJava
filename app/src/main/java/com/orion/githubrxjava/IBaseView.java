package com.orion.githubrxjava;

public interface IBaseView<T extends IBasePresenter> {
    void setPresenter(T presenter);
}