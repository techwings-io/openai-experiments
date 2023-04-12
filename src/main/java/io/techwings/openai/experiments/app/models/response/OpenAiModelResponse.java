package io.techwings.openai.experiments.app.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OpenAiModelResponse {

    @JsonProperty("object")
    private String object;

    @JsonProperty("data")
    private List<OpenAIModel> models;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OpenAIModel {
        private String id;
        private String object;
        private Long created;
        @JsonProperty("owned_by")
        private String ownedBy;
        @JsonProperty("permission")
        private List<Permission> permissions = new ArrayList<>();
        private String root;
        private String parent;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Permission {
        private String id;
        private String object;
        private String created;
        @JsonProperty("allow_create_engine")
        private boolean allowCreateEngine;
        @JsonProperty("allow_sampling")
        private boolean allowSampling;
        @JsonProperty("allow_logprobs")
        private boolean allowLogProbs;
        @JsonProperty("allow_search_indices")
        private boolean allowSearchIndices;
        @JsonProperty("allow_view")
        private boolean allowView;
        @JsonProperty("allow_fine_tuning")
        private boolean allowFineTuning;
        private String organization;
        private String group;
        @JsonProperty("is_blocking")
        private boolean isBlocking;
    }

}
