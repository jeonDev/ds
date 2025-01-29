package com.jh.ds.endpoint;

import com.jh.ds.application.external.service.AiService;
import com.jh.ds.application.external.service.request.OpenAiSendRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiEndpoint {
    private final AiService aiService;

    public AiEndpoint(AiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/api/v1/ai")
    public String ai() {
        OpenAiSendRequest.Messages message = OpenAiSendRequest.Messages.builder()
                .role("user")
                .content("Hello")
                .build();
        OpenAiSendRequest request = OpenAiSendRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(new OpenAiSendRequest.Messages[]{message})
                .maxTokens("256")
                .build();
        return aiService.send(request).toString();
    }
}
