package com.jh.ds.application.external.service;

import com.jh.ds.application.external.service.request.OpenAiSendRequest;
import com.jh.ds.application.external.service.request.OpenAiSendResponse;

public interface AiService {
    OpenAiSendResponse send(OpenAiSendRequest request);
}
