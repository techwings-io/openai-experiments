package io.techwings.openai.experiments.demo.app.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Permission {
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

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created='" + created + '\'' +
                ", allowCreateEngine=" + allowCreateEngine +
                ", allowSampling=" + allowSampling +
                ", allowLogProbs=" + allowLogProbs +
                ", allowSearchIndices=" + allowSearchIndices +
                ", allowView=" + allowView +
                ", allowFineTuning=" + allowFineTuning +
                ", organization='" + organization + '\'' +
                ", group='" + group + '\'' +
                ", isBlocking=" + isBlocking +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permission that)) return false;
        return allowCreateEngine == that.allowCreateEngine &&
                allowSampling == that.allowSampling
                && allowLogProbs == that.allowLogProbs
                && allowSearchIndices == that.allowSearchIndices
                && allowView == that.allowView
                && allowFineTuning == that.allowFineTuning
                && isBlocking == that.isBlocking
                && Objects.equals(id, that.id)
                && Objects.equals(object, that.object)
                && Objects.equals(created, that.created)
                && Objects.equals(organization, that.organization)
                && Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                object, created, allowCreateEngine, allowSampling,
                allowLogProbs, allowSearchIndices, allowView, allowFineTuning,
                organization, group, isBlocking);
    }
}
