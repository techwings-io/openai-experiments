package io.techwings.openai.experiments.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


import java.util.ArrayList;
import java.util.List;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OpenAiResponseForModels {

    private String id;
    private String object;
    private Long created;
    @JsonProperty("owned_by")
    private String ownedBy;
    @JsonProperty("permission")
    private List<Permission> permissions = new ArrayList<>();
    private String root;
    private String parent;

    @Override
    public String toString() {
        return "OpenAiResponseForModels{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created='" + created + '\'' +
                ", ownedBy='" + ownedBy + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
