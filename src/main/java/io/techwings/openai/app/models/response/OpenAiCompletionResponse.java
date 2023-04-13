package io.techwings.openai.app.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.techwings.openai.app.models.common.OpenAIUsage;
import io.techwings.openai.app.models.common.OpenAiChoice;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenAiCompletionResponse {

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