package io.techwings.openai.experiments.demo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.Arrays;

@SpringBootTest
class DemoApplicationTests {
    @Value("${OPENAI_API_KEY}")
    private String openaiApiKey;

    @Value("${OPENAI_API_ORG}")
    private String openaiOrg;
    @Test
    void serialisesAJsonPayload_toOpenAiResponseModel() throws Exception {
        File f = new File("src/test/resources/modelPayload.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
        OpenAiResponseWrapperForModels openAiResponseWrapperForModelsForModels =
                mapper.readValue(f, OpenAiResponseWrapperForModels.class);
        Arrays.stream(openAiResponseWrapperForModelsForModels.getModels()).toList()
                .forEach(m -> System.out.println(m.toString()));
    }

}
