package io.techwings.openai.experiments.app.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.techwings.openai.experiments.app.models.common.OpenAiMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenAiChatRequest {

    @JsonProperty("model")
    private String model;

    @JsonProperty("messages")
    private List<OpenAiMessage> openAiMessages;
}
