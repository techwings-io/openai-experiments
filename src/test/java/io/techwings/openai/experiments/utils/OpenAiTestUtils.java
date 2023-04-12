package io.techwings.openai.experiments.utils;

import io.techwings.openai.experiments.app.models.request.OpenAiCompletionRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Collections;

public class OpenAiTestUtils {
    public static OpenAiCompletionRequest makeCompletionRequestBusinessObject() {
        OpenAiCompletionRequest request = new OpenAiCompletionRequest();
        request.setModel("text-davinci-003");
        request.setPrompt("Say this is a test");
        request.setMaxTokens(7);
        request.setTemperature(0.0);
        request.setTopP(1);
        request.setN(1);
        request.setStream(false);
        request.setLogProbs(null);
        request.setEcho(true);
        request.setStop("\n");
        return request;
    }

    @NotNull
    public static HttpHeaders prepareHttpHeaders(String openApiKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(openApiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }
}