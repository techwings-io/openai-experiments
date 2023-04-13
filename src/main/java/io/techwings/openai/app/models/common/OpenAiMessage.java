package io.techwings.openai.app.models.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenAiMessage {

    @JsonProperty("role")
    private String role;
    @JsonProperty("content")
    private String content;
}
