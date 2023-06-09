package io.techwings.openai.app.models.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenAiChoice {
    private String text;
    private Integer index;
    @JsonProperty("logprobs")
    private String logProbs;
    @JsonProperty("finish_reason")
    private String finishReason;
}
