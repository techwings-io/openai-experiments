package io.techwings.openai.app.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.techwings.openai.app.models.common.OpenAiMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenAiChatResponseChoice {
    private int index;
    private OpenAiMessage message;
    @JsonProperty("finish_reason")
    private String finishReason;
}
