package io.techwings.openai.experiments.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.techwings.openai.experiments.app.models.request.OpenAiChatRequest;
import io.techwings.openai.experiments.app.models.response.OpenAiChatResponse;
import io.techwings.openai.experiments.main.OpenAiInteractionApplication;
import io.techwings.openai.experiments.utils.OpenAiTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



@SpringBootTest(classes = OpenAiInteractionApplication.class)
public class ChatApiIntegrationTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    private ObjectMapper mapper;
    @BeforeEach
    public void setup() {
        mapper = new ObjectMapper();
    }

    @Test
    void successfulRequestToChat_shouldReturnAValidPayload() throws Exception {
        String url = "https://api.openai.com/v1/chat/completions";
        OpenAiChatRequest request = OpenAiTestUtils.makeOpenAiChatRequest();
        HttpEntity<OpenAiChatRequest> httpEntity = new HttpEntity<>(request, httpHeaders);
        ResponseEntity<OpenAiChatResponse> response =
                restTemplate.postForEntity(url, httpEntity, OpenAiChatResponse.class);
        Assertions.assertTrue(response.getStatusCode().value() > 0);
        String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response.getBody());
        System.out.println(prettyJson);
    }
}
