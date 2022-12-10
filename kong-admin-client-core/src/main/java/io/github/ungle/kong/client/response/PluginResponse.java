package io.github.ungle.kong.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.enums.ProtocolEnum;
import io.github.ungle.kong.client.model.IdNameRelation;

import java.util.Map;
import java.util.Set;

public class PluginResponse {

    @JsonProperty("route")
    private IdNameRelation route;

    @JsonProperty("service")
    private IdNameRelation service;

    @JsonProperty("name")
    private String name;

    @JsonProperty("created_at")
    private Long createdAt;

    @JsonProperty("id")
    private String id;

    @JsonProperty("protocols")
    private Set<ProtocolEnum> protocols;

    @JsonProperty("config")
    private Map<String, Object> config;

    @JsonProperty("consumer")
    private IdNameRelation consumer;

    @JsonProperty("enabled")
    private boolean enabled;

    @JsonProperty("run_on")
    private String runOn;

    @JsonProperty("tags")
    private Set<String> tags;

    public PluginResponse() {
    }

    public IdNameRelation getRoute() {
        return route;
    }

    public void setRoute(IdNameRelation route) {
        this.route = route;
    }

    public IdNameRelation getService() {
        return service;
    }

    public void setService(IdNameRelation service) {
        this.service = service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<ProtocolEnum> getProtocols() {
        return protocols;
    }

    public void setProtocols(Set<ProtocolEnum> protocols) {
        this.protocols = protocols;
    }

    public Map<String, Object> getConfig() {
        return config;
    }

    public void setConfig(Map<String, Object> config) {
        this.config = config;
    }

    public IdNameRelation getConsumer() {
        return consumer;
    }

    public void setConsumer(IdNameRelation consumer) {
        this.consumer = consumer;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRunOn() {
        return runOn;
    }

    public void setRunOn(String runOn) {
        this.runOn = runOn;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}