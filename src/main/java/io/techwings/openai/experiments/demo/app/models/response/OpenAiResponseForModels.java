package io.techwings.openai.experiments.demo.app.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpenAiResponseForModels that)) return false;
        return Objects.equals(id, that.id) &&
                Objects.equals(object, that.object) &&
                Objects.equals(created, that.created) &&
                Objects.equals(ownedBy, that.ownedBy) &&
                Objects.equals(permissions, that.permissions) &&
                Objects.equals(root, that.root) &&
                Objects.equals(parent, that.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, object, created, ownedBy, permissions, root, parent);
    }
}
