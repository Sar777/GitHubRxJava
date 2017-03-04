package com.orion.githubrxjava.services;

import com.orion.githubrxjava.models.Repository;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GithubAPI {
    String SERVICE_ENDPOINT = "https://api.github.com";

    @GET("/users/{username}/repos")
    Observable<List<Repository>> getRepositoryList(@Path("username") String username);
}
