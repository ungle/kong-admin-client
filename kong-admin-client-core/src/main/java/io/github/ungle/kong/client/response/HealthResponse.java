package io.github.ungle.kong.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.model.IdNameRelation;
import io.github.ungle.kong.client.model.TargetData;

import java.math.BigDecimal;
import java.util.Set;

public class HealthResponse {
	
    @JsonProperty("health")
    private String health;

    @JsonProperty("data")
    private TargetData data;

    @JsonProperty("upstream")
    private IdNameRelation upstream;

    @JsonProperty("created_at")
    private BigDecimal createdAt;

    @JsonProperty("weight")
    private int weight;

    @JsonProperty("id")
    private String id;

    @JsonProperty("target")
    private String target;

    @JsonProperty("tags")
    private Set<String> tags;



    public HealthResponse() {
    }

    public IdNameRelation getUpstream() {
        return upstream;
    }

    public void setUpstream(IdNameRelation upstream) {
        this.upstream = upstream;
    }

    public BigDecimal getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(BigDecimal createdAt) {
        this.createdAt = createdAt;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
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

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public TargetData getData() {
        return data;
    }

    public void setData(TargetData data) {
        this.data = data;
    }
}
