package io.techwings.openai.experiments.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.techwings.openai.experiments.app.models.request.OpenAiChatRequest;
import io.techwings.openai.experiments.utils.OpenAiTestUtils;
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

    }

}
