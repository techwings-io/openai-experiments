package io.techwings.openai.experiments.demo;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
public class OpenAITestService implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private OpenAiService openAiService;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt("Say Hello!")
                .model("ada")
                .echo(true)
                .maxTokens(10)
                .build();
        openAiService.createCompletion(completionRequest)
                .getChoices()
                .forEach(System.out::println);
    }
}
