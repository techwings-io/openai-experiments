package io.techwings.openai.experiments.demo.app.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenAIChoice {

    @JsonProperty("text")
    private String text;

    @JsonProperty("index")
    private Integer index;

    @JsonProperty("logprobs")
    private OpenAILogprobs logprobs;

    @JsonProperty("finish_reason")
    private String finishReason;

}
