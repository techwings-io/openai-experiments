package io.techwings.openai.experiments.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.techwings.openai.experiments")
public class OpenAiInteractionApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenAiInteractionApplication.class, args);
    }

}
