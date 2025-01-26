package com.jh.ds.application.external.service.response;

import java.util.List;

public record GitApiReposCommitsDiffResponse(
        String sha,
        Commit commit,
        List<Files> files
) {
    public String toResponse() {
        return this.toString();
    }

    public record Commit(
            String message
    ){}

    public record Files (
            String filename,
            String status,
            Integer additions,
            Integer deletions,
            Integer changes,
            String patch
    ){}
}
