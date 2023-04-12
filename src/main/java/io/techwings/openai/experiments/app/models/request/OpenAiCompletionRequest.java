package io.techwings.openai.experiments.app.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenAiCompletionRequest {

    @JsonProperty("model")
    private String model;

    @JsonProperty("prompt")
    private String prompt;

    @JsonProperty("temperature")
    private Double temperature;

    @JsonProperty("max_tokens")
    private Integer maxTokens;

    @JsonProperty("top_p")
    private Integer topP;

    @JsonProperty("n")
    private Integer n;

    @JsonProperty("logprobs")
    private Integer logProbs;

    @JsonProperty("stop")
    private String stop;

    @JsonProperty("echo")
    private Boolean echo;

    @JsonProperty("stream")
    private Boolean stream;

}
