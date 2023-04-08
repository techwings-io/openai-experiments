package io.techwings.openai.experiments.demo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        List<OpenAiResponseForModels> models =
                Arrays.asList(openAiResponseWrapperForModelsForModels.getModels());
        assertFalse(models.isEmpty());
        models.forEach(System.out::println);
    }

}
