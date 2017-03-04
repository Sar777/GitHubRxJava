package com.orion.githubrxjava.main;

import com.orion.githubrxjava.IBaseView;
import com.orion.githubrxjava.models.Repository;

import java.util.List;

public interface IMainView extends IBaseView<MainPresenter> {
    void showProgress();
    void hideProgress();

    void showLoadButton();
    void hideLoadButton();

    void setRepositories(List<Repository> repositories);
}
