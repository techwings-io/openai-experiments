package io.techwings.openai.app.models.response;

import io.techwings.openai.app.models.common.OpenAIUsage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenAiChatResponse {

    private String id;
    private String object;
    private Long created;
    private List<OpenAiChatResponseChoice> choices;
    private OpenAIUsage usage;

}