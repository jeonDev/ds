package com.jh.ds.application.external.service.response;

public record GitApiReposCommitsInfo(
        String sha,
        Commit commit
) {
    public record Commit(
            String message
    ) {
    }
}
