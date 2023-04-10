package io.techwings.openai.experiments.demo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.techwings.openai.experiments.demo.app.models.OpenAiResponseForModels;
import io.techwings.openai.experiments.demo.app.models.OpenAiResponseWrapperForModels;
import io.techwings.openai.experiments.demo.app.models.Permission;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

import static org.junit.jupiter.api.Assertions.*;

class OpenAiPayloadsForModelsTest {
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

    @Test
    void modelInPayloadMustContainGptTurbo() throws Exception {
        List<OpenAiResponseForModels> modelsList = getModelsAsList();
        assertTrue(modelsList.size() > 0);
        long count = getCountOfGptTurbo(modelsList);
        assertTrue(count > 0);
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
    @NotNull
    private List<OpenAiResponseForModels> getModelsAsList() throws IOException {
        OpenAiResponseWrapperForModels responseWrapperForModels = readPayloadInputAsJson(mapper);
        OpenAiResponseForModels[] models = responseWrapperForModels.getModels();
        List<OpenAiResponseForModels> modelsList = Arrays.asList(models);
        return modelsList;
    }
    private static long getCountOfGptTurbo(List<OpenAiResponseForModels> modelsList) {
        long count = modelsList.stream()
                .filter(m -> m.getId().contains("gpt-3.5-turbo"))
                .count();
        return count;
    }

}
