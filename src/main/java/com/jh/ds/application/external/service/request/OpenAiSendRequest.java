package com.jh.ds.application.external.service.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record OpenAiSendRequest(
        @JsonProperty("model")
        String model,
        @JsonProperty("messages")
        Messages[] messages,
        @JsonProperty("max_tokens")
        String maxTokens
) {
        @Builder
        public record Messages(
                @JsonProperty("role")
                String role,
                @JsonProperty("content")
                String content
        ) {}
}
