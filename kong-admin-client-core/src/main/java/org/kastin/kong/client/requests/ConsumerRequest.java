package org.kastin.kong.client.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class ConsumerRequest extends Request {

    @JsonProperty("custom_id")
    private String customId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("tags")
    private Set<String> tags;

    public ConsumerRequest() {
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}