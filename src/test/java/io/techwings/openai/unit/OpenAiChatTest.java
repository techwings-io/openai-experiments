package io.techwings.openai.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.techwings.openai.app.models.request.OpenAiChatRequest;

import io.techwings.openai.app.models.response.OpenAiChatResponse;
import io.techwings.openai.utils.OpenAiTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class OpenAiChatTest {

    private ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        mapper = new ObjectMapper();
    }

    @Test
    void testJsonRequest_mapsToBusinessObject() throws Exception {
        OpenAiChatRequest request = OpenAiTestUtils.makeOpenAiChatRequest();
        File f = new File("src/test/resources/chat-request.json");
        OpenAiChatRequest original = mapper.readValue(f, OpenAiChatRequest.class);
        Assertions.assertEquals(request, original);
    }

    @Test
    void testJsonResponse_mapsToBusinessObject() throws Exception {
        File f = new File("src/test/resources/chat-response.json");
        mapper.readValue(f, OpenAiChatResponse.class);
    }

}
