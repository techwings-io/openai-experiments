package io.techwings.openai.app.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class OpenAiConfiguration {

    @Value("${OPEN_AI_KEY}")
    private String openAiKey;

    @Bean
    public HttpHeaders prepareHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(openAiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }

    @Bean
    public String openAiKey() {
        return this.openAiKey;
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
