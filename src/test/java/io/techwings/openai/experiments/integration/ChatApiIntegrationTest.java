package io.techwings.openai.experiments.integration;

import io.techwings.openai.experiments.app.models.request.OpenAiChatRequest;
import io.techwings.openai.experiments.app.models.response.OpenAiChatResponse;
import io.techwings.openai.experiments.main.OpenAiInteractionApplication;
import io.techwings.openai.experiments.app.services.OpenAiChatService;
import io.techwings.openai.experiments.utils.OpenAiTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(classes = OpenAiInteractionApplication.class)
public class ChatApiIntegrationTest {

    @Autowired
    private OpenAiChatService chatService;

    private OpenAiChatRequest request;

    @BeforeEach
    public void setup() {
        request = OpenAiTestUtils.makeOpenAiChatRequest();
    }

    @Test
    void chatServiceCall_returnsAValidPayload() {
        OpenAiChatResponse chatResponse =
                chatService.makeChatRequest(request);
        assertNotNull(chatResponse);
    }

    @Test()
    void chatServiceCallWithInvalidPayload_mustThrowError() {
        request = OpenAiTestUtils.makeInvalidChatRequest();
        OpenAiChatService.ChatEndpointInvocationError thrown =
                Assertions.assertThrows(
                        OpenAiChatService.ChatEndpointInvocationError.class,
                        () -> chatService.makeChatRequest(request),
                        "Expected ChatEndpointInvocationError but it wasn't thown"
                );
        assertNotNull(thrown.getCause().getMessage());
    }
}
