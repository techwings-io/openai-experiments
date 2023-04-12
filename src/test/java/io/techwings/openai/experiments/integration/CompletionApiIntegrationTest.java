package io.techwings.openai.experiments.integration;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.techwings.openai.experiments.main.OpenAiInteractionApplication;
import io.techwings.openai.experiments.app.models.request.OpenAiCompletionRequest;
import io.techwings.openai.experiments.app.models.response.OpenAIResponseModelForCompletion;
import io.techwings.openai.experiments.utils.OpenAiTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes = OpenAiInteractionApplication.class)
public class CompletionApiIntegrationTest {

    @Autowired
    private RestTemplate restTemplate;

    private ObjectMapper mapper;

    @Autowired
    private HttpHeaders httpHeaders;

    @BeforeEach
    public void setup() {
        mapper = new ObjectMapper();
    }

    @Test
    void sendingACompletionRequest_returnsValidResponse() throws Exception {
        OpenAiCompletionRequest request = OpenAiTestUtils.makeCompletionRequestBusinessObject();

        HttpEntity<OpenAiCompletionRequest> httpEntity = new HttpEntity<>(request, httpHeaders);
        ResponseEntity<OpenAIResponseModelForCompletion> response =
                restTemplate.postForEntity("https://api.openai.com/v1/completions",
                        httpEntity,
                        OpenAIResponseModelForCompletion.class);
        HttpStatusCode statusCode = response.getStatusCode();
        Assertions.assertTrue(statusCode.value() > 0);
        String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response.getBody());
        System.out.println(prettyJson);
    }


}
