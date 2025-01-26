package com.jh.ds.application.external.impl;

import com.jh.ds.application.external.service.GitApiService;
import com.jh.ds.application.external.service.request.GitApiReposCommitsRequest;
import com.jh.ds.application.external.service.response.GitApiReposCommitsResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class GitApiServiceImplTest {

    @Autowired
    private GitApiService gitApiService;


    @Test
    void 커밋내역_조회() {
        GitApiReposCommitsRequest request = GitApiReposCommitsRequest.builder()
                .owner("jeonDev")
                .repo("pay")
                .build();
        GitApiReposCommitsResponse response = gitApiService.getReposCommitsHistory(request);
    }
}