package org.kastin.kong.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

import org.kastin.kong.client.model.IdNameRelation;

public class TargetResponse {

    @JsonProperty("upstream")
    private IdNameRelation upstream;

    @JsonProperty("created_at")
    private Long createdAt;

    @JsonProperty("weight")
    private Integer weight;

    @JsonProperty("id")
    private String id;

    @JsonProperty("target")
    private String target;

    @JsonProperty("tags")
    private Set<String> tags;

    public TargetResponse() {
    }

    public IdNameRelation getUpstream() {
        return upstream;
    }

    public void setUpstream(IdNameRelation upstream) {
        this.upstream = upstream;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}