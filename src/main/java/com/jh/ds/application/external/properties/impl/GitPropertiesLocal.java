package com.jh.ds.application.external.properties.impl;

import com.jh.ds.application.external.properties.GitProperties;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Component
@Profile("local")
@PropertySource("classpath:/properties/gitProperties-local.yml")
public class GitPropertiesLocal implements GitProperties {
    @Value("${base-url}")
    private String url;

    @Value("${repos-commits-uri}")
    private String apiUriReposCommits;

    public String getApiUriReposCommits(String owner, String repo) {
        return String.format(apiUriReposCommits, owner, repo);
    }
}
