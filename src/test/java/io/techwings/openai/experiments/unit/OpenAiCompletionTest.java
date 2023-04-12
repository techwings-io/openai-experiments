package io.techwings.openai.experiments.unit;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.techwings.openai.experiments.app.models.request.OpenAiCompletionRequest;
import io.techwings.openai.experiments.app.models.response.OpenAiResponseModelForCompletion;

import io.techwings.openai.experiments.utils.OpenAiTestUtils;
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
        OpenAiCompletionRequest request = OpenAiTestUtils.makeCompletionRequestBusinessObject();
        OpenAiCompletionRequest original = retrieveOriginalJsonPayload();
        Assertions.assertEquals(request, original);
    }

    @Test
    void validateBusinessObject_generatesValidJsonString() throws Exception {
        OpenAiCompletionRequest request = OpenAiTestUtils.makeCompletionRequestBusinessObject();
        String valueAsString = mapper.writeValueAsString(request);
        Assertions.assertTrue(StringUtils.isNotBlank(valueAsString));
    }
    @Test
    void jsonResponsePayload_canBeParsedIntoBusinessObject() throws Exception {
        File f = getJsonResponsePayloadForCompletion();
        mapper.readValue(f, OpenAiResponseModelForCompletion.class);
        // Would throw an exception before getting here. Works as assertions
    }

    private File getJsonResponsePayloadForCompletion() {
        return new File("src/test/resources/completion-response.json");
    }

    private OpenAiCompletionRequest retrieveOriginalJsonPayload() throws IOException {
        File f = new File("src/test/resources/completion-request.json");
        return mapper.readValue(f, OpenAiCompletionRequest.class);
    }

}
