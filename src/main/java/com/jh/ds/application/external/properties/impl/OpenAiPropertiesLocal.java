package com.jh.ds.application.external.properties.impl;

import com.jh.ds.application.external.properties.OpenAiProperties;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Component
@Profile("local")
@PropertySource("classpath:/properties/openaiProperties-local.yml")
public class OpenAiPropertiesLocal implements OpenAiProperties {

    @Value("${secret-key}")
    private String secretKey;

    @Value("${completions-url}")
    private String completionsUrl;
}
