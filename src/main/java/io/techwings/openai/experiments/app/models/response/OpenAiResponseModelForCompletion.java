package io.techwings.openai.experiments.app.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.techwings.openai.experiments.app.models.common.OpenAIUsage;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenAiResponseModelForCompletion {

    @JsonProperty("id")
    private String id;

    @JsonProperty("object")
    private String object;

    @JsonProperty("created")
    private Long created;

    @JsonProperty("model")
    private String model;

    @JsonProperty("choices")
    private List<OpenAiChoice> choices;

    @JsonProperty("usage")
    private OpenAIUsage usage;

}