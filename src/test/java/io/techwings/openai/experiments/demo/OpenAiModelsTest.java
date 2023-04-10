package io.techwings.openai.experiments.demo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.techwings.openai.experiments.demo.app.models.OpenAiResponseForModels;
import io.techwings.openai.experiments.demo.app.models.OpenAiResponseWrapperForModels;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class OpenAiModelsTest {


    private ObjectMapper mapper;
    @BeforeEach
    public void setup() {
        mapper = prepareObjectMapper();
    }

    @Test
    void deserialisesTheOpenAiModelsJsonPayload_toADomainModel() throws Exception {
        OpenAiResponseWrapperForModels responseWrapperForModels = readPayloadInputAsJson(mapper);
        validateReturnedPayload(responseWrapperForModels);
    }

    @NotNull
    private static ObjectMapper prepareObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
        return mapper;
    }

    private static OpenAiResponseWrapperForModels readPayloadInputAsJson(ObjectMapper mapper)
            throws IOException {
        File f = new File("src/test/resources/modelPayload.json");
        return mapper.readValue(f, OpenAiResponseWrapperForModels.class);
    }

    private static void validateReturnedPayload(OpenAiResponseWrapperForModels responseWrapperForModels) {
        List<OpenAiResponseForModels> models =
                Arrays.asList(responseWrapperForModels.getModels());
        assertFalse(models.isEmpty());
        models.forEach(System.out::println);
    }

}
