package io.techwings.openai.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.techwings.openai")
public class OpenAiInteractionApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenAiInteractionApplication.class, args);
    }

}
