package com.orion.githubrxjava.main;

import com.orion.githubrxjava.models.Repository;
import com.orion.githubrxjava.services.GithubAPI;
import com.orion.githubrxjava.services.ServiceFactory;

import java.util.List;

import rx.Observable;

public class MainModelImpl implements MainModel {
    @Override
    public Observable<List<Repository>> getRepositoryList(String username) {
        GithubAPI service  = ServiceFactory.createRetrofitService(GithubAPI.class, GithubAPI.SERVICE_ENDPOINT);
        return service.getRepositoryList(username);
    }
}
