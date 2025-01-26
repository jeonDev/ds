package com.jh.ds.application.external.service;

import com.jh.ds.application.external.service.request.GitApiReposCommitsRequest;
import com.jh.ds.application.external.service.response.GitApiReposCommitsResponse;

public interface GitApiService {

    GitApiReposCommitsResponse getReposCommitsHistory(GitApiReposCommitsRequest request);
}
