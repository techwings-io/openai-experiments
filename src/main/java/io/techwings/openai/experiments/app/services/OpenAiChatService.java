package io.techwings.openai.experiments.app.services;

import io.techwings.openai.experiments.app.models.request.OpenAiChatRequest;
import io.techwings.openai.experiments.app.models.response.OpenAiChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAiChatService {
    @Value("${openai.chat.url}")
    private String chatEndpointUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;
    public OpenAiChatResponse makeChatRequest(OpenAiChatRequest request) {

        HttpEntity<OpenAiChatRequest> httpEntity = new HttpEntity<>(request, httpHeaders);
        ResponseEntity<OpenAiChatResponse> response;
        try {
            response =  restTemplate.postForEntity(chatEndpointUrl, httpEntity, OpenAiChatResponse.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            throw new ChatEndpointInvocationError(e);
        }

    }


    public static class ChatEndpointInvocationError extends RuntimeException {
        public ChatEndpointInvocationError(HttpClientErrorException e) {
            super(e);
        }
    }
}


