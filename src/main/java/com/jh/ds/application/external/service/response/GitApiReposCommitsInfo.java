package com.jh.ds.application.external.service.response;

import java.util.List;

public record GitApiReposCommitsInfo(
        Commit commit,
        List<File> files
) {
    public record Commit(
            String message
    ) {
    }

    public record File(
            String filename,
            String status,
            String changes
    ) {
    }
}
