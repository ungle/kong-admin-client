package org.kastin.kong.client.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.kastin.kong.client.enums.ProtocolEnum;
import org.kastin.kong.client.model.IdNameRelation;
import org.kastin.kong.client.model.plugins.PluginConfig;

public class PluginRequest extends Request {

    @JsonProperty("route")
    private IdNameRelation route;

    @JsonProperty("service")
    private IdNameRelation service;

    @JsonProperty("name")
    private String name;

    @JsonProperty("protocols")
    private Set<ProtocolEnum> protocols = new HashSet<>(Arrays.asList(ProtocolEnum.GRPC, ProtocolEnum.GRPCS, ProtocolEnum.HTTP, ProtocolEnum.HTTPS));
    ;

    @JsonProperty("config")
    private PluginConfig config;

    @JsonProperty("consumer")
    private IdNameRelation consumer;

    @JsonProperty("enabled")
    private boolean enabled = true;

    @JsonProperty("run_on")
    private String runOn;

    @JsonProperty("tags")
    private Set<String> tags;

    public PluginRequest() {
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

    public Set<ProtocolEnum> getProtocols() {
        return protocols;
    }

    public void setProtocols(Set<ProtocolEnum> protocols) {
        this.protocols = protocols;
    }

    public PluginConfig getConfig() {
        return config;
    }

    public void setConfig(PluginConfig config) {
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