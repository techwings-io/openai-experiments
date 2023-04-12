package io.techwings.openai.experiments.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAiConfiguration {

    @Value("${OPEN_AI_KEY}")
    private String openAiKey;

    @Bean
    public String openAiKey() {
        return this.openAiKey;
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
