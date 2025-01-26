package com.jh.ds.application.external.service.request;

import lombok.Builder;

@Builder
public record GitApiReposCommitsDiffRequest(
        String owner,
        String repo,
        String since,
        String until,
        String sha
) {
}
