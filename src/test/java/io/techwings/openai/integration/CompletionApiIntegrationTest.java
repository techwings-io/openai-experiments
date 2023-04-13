package io.techwings.openai.integration;

import io.techwings.openai.app.models.request.OpenAiCompletionRequest;
import io.techwings.openai.app.models.response.OpenAiCompletionResponse;
import io.techwings.openai.main.OpenAiInteractionApplication;
import io.techwings.openai.utils.OpenAiTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes = OpenAiInteractionApplication.class)
public class CompletionApiIntegrationTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    @Value("${openai.completion.url}")
    private String url;

    @Test
    void sendingACompletionRequest_returnsValidResponse() {
        OpenAiCompletionRequest request = OpenAiTestUtils.makeCompletionRequestBusinessObject();
        HttpEntity<OpenAiCompletionRequest> httpEntity = new HttpEntity<>(request, httpHeaders);
        ResponseEntity<OpenAiCompletionResponse> response =
                restTemplate.postForEntity(url, httpEntity, OpenAiCompletionResponse.class);
        HttpStatusCode statusCode = response.getStatusCode();
        Assertions.assertEquals(200, statusCode.value());
    }

}
