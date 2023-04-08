package io.techwings.openai.experiments.demo;


import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpenAITestService implements ApplicationListener<ContextRefreshedEvent> {
    @Value("${OPENAI_API_KEY}")
    private String openaiApiKey;

    @Value("${OPENAI_API_ORG}")
    private String openaiOrg;
    private static final String url = "https://api.openai.com/v1/chat/completions";
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    }
}
