package com.jh.ds.application.external.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jh.ds.application.external.service.GitApiService;
import com.jh.ds.application.external.properties.GitProperties;
import com.jh.ds.application.external.service.request.GitApiReposCommitsDiffRequest;
import com.jh.ds.application.external.service.request.GitApiReposCommitsRequest;
import com.jh.ds.application.external.service.response.GitApiReposCommitsDiffResponse;
import com.jh.ds.application.external.service.response.GitApiReposCommitsInfo;
import com.jh.ds.application.external.service.response.GitApiReposCommitsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Slf4j
@Component
public class GitApiServiceImpl implements GitApiService {

    private final RestClient restClient;
    private final GitProperties gitProperties;
    private final ObjectMapper objectMapper;

    public GitApiServiceImpl(GitProperties gitProperties,
                             ObjectMapper objectMapper) {
        this.gitProperties = gitProperties;
        this.objectMapper = objectMapper;
        this.restClient = RestClient.builder()
                .baseUrl(gitProperties.getUrl())
                .build();
    }

    @Override
    public GitApiReposCommitsResponse getReposCommitsHistory(GitApiReposCommitsRequest request) {

        String path = gitProperties.getApiUriReposCommits(request.owner(), request.repo());
        log.info(path);
        ResponseEntity<String> response = restClient.get()
                .uri(path)
                .retrieve()
                .toEntity(String.class);
        if (!HttpStatus.OK.equals(response.getStatusCode())) {
            throw new RuntimeException("");
        }

        try {
            List<GitApiReposCommitsInfo> list = objectMapper.readValue(response.getBody(), objectMapper.getTypeFactory().constructCollectionType(List.class, GitApiReposCommitsInfo.class));

            return GitApiReposCommitsResponse.builder()
                    .gitApiReposCommitsInfos(list)
                    .build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GitApiReposCommitsDiffResponse getReposCommitsDiffHistory(GitApiReposCommitsDiffRequest request) {
        String path = gitProperties.getApiUriReposCommitsDiff(request.owner(), request.repo(), request.sha());
        log.info(path);
        ResponseEntity<String> response = restClient.get()
                .uri(path)
                .retrieve()
                .toEntity(String.class);
        if (!HttpStatus.OK.equals(response.getStatusCode())) {
            throw new RuntimeException("");
        }

        try {
            return objectMapper.readValue(response.getBody(), GitApiReposCommitsDiffResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
