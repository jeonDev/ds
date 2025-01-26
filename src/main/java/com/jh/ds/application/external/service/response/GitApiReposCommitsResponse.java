package com.jh.ds.application.external.service.response;

import lombok.Builder;

import java.util.List;

@Builder
public record GitApiReposCommitsResponse(
        List<GitApiReposCommitsInfo> gitApiReposCommitsInfos
) {
}
