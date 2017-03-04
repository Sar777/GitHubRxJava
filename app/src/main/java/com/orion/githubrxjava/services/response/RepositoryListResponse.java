package com.orion.githubrxjava.services.response;

import com.orion.githubrxjava.models.Repository;

import java.util.List;

public class RepositoryListResponse {
    private List<Repository> mRepositoryList;

    public List<Repository> getList() {
        return mRepositoryList;
    }
}
