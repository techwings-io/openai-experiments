package io.techwings.openai.experiments.demo.app.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenAILogprobs {

    @JsonProperty("tokens")
    private List<String> tokens;

    @JsonProperty("token_logprobs")
    private List<Double> tokenLogprobs;

    @JsonProperty("top_logprobs")
    private List<Map<String, Double>> topLogprobs;

}
