package com.jh.ds.application.external.service.impl;

import com.jh.ds.application.external.properties.OpenAiProperties;
import com.jh.ds.application.external.service.AiService;
import com.jh.ds.application.external.service.request.OpenAiSendRequest;
import com.jh.ds.application.external.service.request.OpenAiSendResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
public class OpenAiServiceImpl implements AiService {
    private final RestClient restClient;
    private final OpenAiProperties openAiProperties;

    public OpenAiServiceImpl(OpenAiProperties openAiProperties) {
        this.openAiProperties = openAiProperties;
        this.restClient = RestClient.builder()
                .build();
    }

    @Override
    public OpenAiSendResponse send(OpenAiSendRequest request) {
        ResponseEntity<String> response = restClient.post()
                .uri(openAiProperties.getCompletionsUrl())
                .header("Authorization", "Bearer " + openAiProperties.getSecretKey())
                .body(request)
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(String.class);
        log.info(response.toString());
        log.info(response.getBody());
        return null;
    }
}
