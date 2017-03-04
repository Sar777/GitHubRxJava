package com.orion.githubrxjava.main;

import com.orion.githubrxjava.models.Repository;

import java.util.List;

import rx.Observable;

public interface MainModel {
    Observable<List<Repository>> getRepositoryList(String username);
}
