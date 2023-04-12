package io.techwings.openai.experiments.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.techwings.openai.experiments.demo.app.models.request.OpenAiCompletionRequest;
import io.techwings.openai.experiments.demo.app.models.response.OpenAIResponseModelForCompletion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.io.File;
import java.io.IOException;

public class OpenAiCompletionTest {

    private ObjectMapper mapper;
    @BeforeEach
    public void setup() {
        mapper = new ObjectMapper();
    }

    @Test
    void businessObjectForRequest_transformsToJson() throws Exception {
        OpenAiCompletionRequest request = makeCompletionRequestBusinessObject();
        OpenAiCompletionRequest original = retrieveOriginalJsonPayload();
        Assertions.assertEquals(request, original);
    }

    @Test
    void validateBusinessObject_generatesValidJsonString() throws Exception {
        OpenAiCompletionRequest request = makeCompletionRequestBusinessObject();
        String valueAsString = mapper.writeValueAsString(request);
        Assertions.assertTrue(StringUtils.isNotBlank(valueAsString));
    }
    @Test
    void jsonResponsePayload_canBeParsedIntoBusinessObject() throws Exception {
        File f = getJsonResponsePayloadForCompletion();
        mapper.readValue(f, OpenAIResponseModelForCompletion.class);
        // Would throw an exception before getting here. Works as assertions
    }

    private File getJsonResponsePayloadForCompletion() {
        return new File("src/test/resources/completion-response.json");
    }

    private OpenAiCompletionRequest retrieveOriginalJsonPayload() throws IOException {
        File f = new File("src/test/resources/completion-request.json");
        return mapper.readValue(f, OpenAiCompletionRequest.class);
    }

    private static OpenAiCompletionRequest makeCompletionRequestBusinessObject() {
        OpenAiCompletionRequest request = new OpenAiCompletionRequest();
        request.setModel("text-davinci-003");
        request.setPrompt("Say this is a test");
        request.setMaxTokens(7);
        request.setTemperature(0.0);
        request.setTopP(1);
        request.setN(1);
        request.setStream(false);
        request.setLogProbs(null);
        request.setEcho(false);
        request.setStop("\n");
        return request;
    }
}
