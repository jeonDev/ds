package com.jh.ds.application.external.service.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record OpenAiSendRequest(
        @JsonProperty("model")
        String model,
        @JsonProperty("prompt")
        String prompt,
        @JsonProperty("max_tokens")
        String maxTokens
) {
}
