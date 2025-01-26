package com.jh.ds.endpoint;

import com.jh.ds.application.external.service.GitApiService;
import com.jh.ds.application.external.service.request.GitApiReposCommitsDiffRequest;
import com.jh.ds.application.external.service.request.GitApiReposCommitsRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitEndpoint {

    private final GitApiService gitApiService;

    public GitEndpoint(GitApiService gitApiService) {
        this.gitApiService = gitApiService;
    }

    @GetMapping("/api/v1/git/commit/{owner}/{repos}")
    public String gitCommitHistory(@PathVariable("owner") String owner,
                                   @PathVariable("repos") String repos) {
        GitApiReposCommitsRequest request = GitApiReposCommitsRequest.builder()
                .owner(owner)
                .repo(repos)
                .build();
        return gitApiService.getReposCommitsHistory(request)
                .toResponse();
    }

    @GetMapping("/api/v1/git/commit/{owner}/{repos}/{sha}")
    public String gitCommitDiffHistory(@PathVariable("owner") String owner,
                                   @PathVariable("repos") String repos,
                                   @PathVariable("sha") String sha) {
        GitApiReposCommitsDiffRequest request = GitApiReposCommitsDiffRequest.builder()
                .owner(owner)
                .repo(repos)
                .sha(sha)
                .build();
        return gitApiService.getReposCommitsDiffHistory(request)
                .toResponse();
    }
}
