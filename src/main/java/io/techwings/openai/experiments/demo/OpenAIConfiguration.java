package io.techwings.openai.experiments.demo;

import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfiguration {
    @Value("${OPENAI_API_KEY}")
    private String openaiApiKey;

    @Value("${OPENAI_API_ORG}")
    private String openaiOrg;

    @Bean
    public OpenAiService openAiService() {
        String.format("api key: %s", openaiApiKey);
        String.format("api org: %s", openaiOrg);
        return new OpenAiService(openaiApiKey);
    }
}
