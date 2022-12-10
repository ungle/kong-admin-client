package com.github.ungle.kong.client.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class TargetRequest extends Request {

    @JsonProperty("weight")
    private Integer weight = 100;

    @JsonProperty("target")
    private String target;

    @JsonProperty("tags")
    private Set<String> tags;

    public TargetRequest() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        if (weight < 0 || weight > 1000) {
            throw new IllegalArgumentException("The weight must between 0-1000");
        }
        this.weight = weight;
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