package io.techwings.openai.experiments;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.techwings.openai.experiments.app.models.response.OpenAiResponseModelForModels;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OpenAiModelsTest {
    private ObjectMapper mapper;
    @BeforeEach
    public void setup() {
        mapper = prepareObjectMapper();
    }

    @Test
    void deserialisesTheOpenAiModelsJsonPayload_toADomainModel() throws Exception {
        OpenAiResponseModelForModels responseWrapperForModels = readPayloadInputAsJson(mapper);
        validateReturnedPayload(responseWrapperForModels);
    }

    @Test
    void modelInPayloadMustContainGptTurbo() throws Exception {
        OpenAiResponseModelForModels responseWrapperForModels = readPayloadInputAsJson(mapper);
        long count = getCountOfGptTurbo(responseWrapperForModels.getModels());
        assertTrue(count > 0);
    }
    @NotNull
    private static ObjectMapper prepareObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
        return mapper;
    }

    private static OpenAiResponseModelForModels readPayloadInputAsJson(ObjectMapper mapper)
            throws IOException {
        File f = new File("src/test/resources/modelPayload.json");
        return mapper.readValue(f, OpenAiResponseModelForModels.class);
    }

    private static void validateReturnedPayload(OpenAiResponseModelForModels responseWrapperForModels) {
        assertFalse(responseWrapperForModels.getModels().isEmpty());
    }

    private static long getCountOfGptTurbo(List<OpenAiResponseModelForModels.OpenAIModel> modelsList) {
        return modelsList.stream()
                .filter(m -> m.getId().contains("gpt-3.5-turbo"))
                .count();
    }

}
