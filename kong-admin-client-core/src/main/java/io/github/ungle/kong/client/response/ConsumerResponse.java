package io.github.ungle.kong.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ConsumerResponse {

    @JsonProperty("custom_id")
    private String customId;

    @JsonProperty("created_at")
    private Long createdAt;

    @JsonProperty("id")
    private String id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("tags")
    private List<String> tags;

    public ConsumerResponse() {
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}