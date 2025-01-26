package com.jh.ds.application.external.service;

import com.jh.ds.application.external.service.request.GitApiReposCommitsDiffRequest;
import com.jh.ds.application.external.service.request.GitApiReposCommitsRequest;
import com.jh.ds.application.external.service.response.GitApiReposCommitsDiffResponse;
import com.jh.ds.application.external.service.response.GitApiReposCommitsResponse;

public interface GitApiService {

    GitApiReposCommitsResponse getReposCommitsHistory(GitApiReposCommitsRequest request);
    GitApiReposCommitsDiffResponse getReposCommitsDiffHistory(GitApiReposCommitsDiffRequest request);
}
