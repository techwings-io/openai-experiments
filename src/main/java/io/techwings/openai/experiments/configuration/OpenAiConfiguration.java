package io.techwings.openai.experiments.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAiConfiguration {

    @Value("${OPEN_API_KEY}")
    private String openApiKey;

    @Bean
    public String openApiKey() {
        return this.openApiKey;
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
