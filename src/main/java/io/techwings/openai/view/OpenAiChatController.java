package io.techwings.openai.view;

import io.techwings.openai.app.models.request.OpenAiChatRequest;
import io.techwings.openai.app.models.response.OpenAiChatResponse;
import io.techwings.openai.app.services.OpenAiChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class OpenAiChatController {

    @Autowired
    private OpenAiChatService chatService;

    @PostMapping("/chat")
    public OpenAiChatResponse chat(@RequestBody  OpenAiChatRequest request) {
        try {
            return chatService.makeChatRequest(request);
        } catch (OpenAiChatService.ChatEndpointInvocationError e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Open Ai chat request", e);
        }

    }
}
