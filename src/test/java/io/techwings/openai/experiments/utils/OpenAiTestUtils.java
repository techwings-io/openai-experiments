package io.techwings.openai.experiments.utils;

import io.techwings.openai.experiments.app.models.common.OpenAiMessage;
import io.techwings.openai.experiments.app.models.request.OpenAiChatRequest;
import io.techwings.openai.experiments.app.models.request.OpenAiCompletionRequest;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OpenAiTestUtils {
    public static OpenAiCompletionRequest makeCompletionRequestBusinessObject() {
        OpenAiCompletionRequest request = new OpenAiCompletionRequest();
        request.setModel("text-davinci-003");
        request.setPrompt("Say this is a test");
        request.setMaxTokens(7);
        request.setTemperature(0.0);
        request.setTopP(1);
        request.setN(1);
        request.setStream(false);
        request.setLogProbs(null);
        request.setEcho(true);
        request.setStop("\n");
        return request;
    }

    public static OpenAiChatRequest makeOpenAiChatRequest() {

        OpenAiChatRequest request = new OpenAiChatRequest();
        request.setModel("gpt-3.5-turbo");
        List<OpenAiMessage> openAiMessages = prepareMessages();
        request.setOpenAiMessages(openAiMessages);
        return request;
    }

    @NotNull
    private static List<OpenAiMessage> prepareMessages() {
        OpenAiMessage openAiMessage = new OpenAiMessage("user", "Hello!");
        List<OpenAiMessage> openAiMessages = new ArrayList<>();
        openAiMessages.add(openAiMessage);
        return openAiMessages;
    }
}