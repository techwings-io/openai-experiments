package io.techwings.openai.integration;

import io.techwings.openai.app.models.request.OpenAiChatRequest;
import io.techwings.openai.app.models.response.OpenAiChatResponse;
import io.techwings.openai.main.OpenAiInteractionApplication;
import io.techwings.openai.utils.OpenAiTestUtils;
import io.techwings.openai.view.OpenAiChatController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest(classes = OpenAiInteractionApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OpenAiChatControllerIntegrationTest {

    @Autowired
    private OpenAiChatController controller;

    @Test
    void testController_returnsValidBusinessObject() {
        OpenAiChatRequest request = OpenAiTestUtils.makeOpenAiChatRequest();
        OpenAiChatResponse response = controller.chat(request);
        Assertions.assertNotNull(response);
    }

    @Test
    void invalidRequestToController_throwsError() {
        OpenAiChatRequest invalidRequest = OpenAiTestUtils.makeInvalidChatRequest();
        ResponseStatusException thrown =
                Assertions.assertThrows(ResponseStatusException.class,
                        () -> controller.chat(invalidRequest));
        Assertions.assertNotNull(thrown.getCause());

    }
}
