package org.kastin.kong.client.response.plugins;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

import org.kastin.kong.client.model.IdNameRelation;

/**
 * 
 * @author ungle
 *
 */
public class AclResponse {
    private String id;
    private String group;
    private Set<String> tags;
    private IdNameRelation consumer;
    @JsonProperty("created_at")
    private Long createdAt;

    public AclResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public IdNameRelation getConsumer() {
        return consumer;
    }

    public void setConsumer(IdNameRelation consumer) {
        this.consumer = consumer;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
}
