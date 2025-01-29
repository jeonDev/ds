package com.jh.ds.application.external.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private final ObjectMapper objectMapper;

    public OpenAiServiceImpl(OpenAiProperties openAiProperties,
                             ObjectMapper objectMapper) {
        this.openAiProperties = openAiProperties;
        this.objectMapper = objectMapper;
        this.restClient = RestClient.builder()
                .build();
    }

    @Override
    public OpenAiSendResponse send(OpenAiSendRequest request) {
        String requestBody;
        try {
            requestBody = objectMapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        ResponseEntity<String> response = restClient.post()
                .uri(openAiProperties.getCompletionsUrl())
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + openAiProperties.getSecretKey())
                .body(requestBody)
                .retrieve()
                .toEntity(String.class);
        log.info(response.toString());
        log.info(response.getBody());
        return null;
    }
}
