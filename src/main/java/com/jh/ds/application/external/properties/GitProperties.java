package com.jh.ds.application.external.properties;

public interface GitProperties {
    String getUrl();
    String getApiUriReposCommits(String owner, String repo);
}
