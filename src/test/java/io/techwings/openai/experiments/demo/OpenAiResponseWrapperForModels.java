package io.techwings.openai.experiments.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OpenAiResponseWrapperForModels {

    @JsonProperty("object")
    private String object;

    @JsonProperty("data")
    private OpenAiResponseForModels[] models;

    @Override
    public String toString() {
        return "OpenAiResponseWrapperForModels{" +
                "object='" + object + '\'' +
                ", models=" + Arrays.toString(models) +
                '}';
    }
}
