package com.github.ungle.kong.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class HealthyCheckUnHealthyStatus {
    @JsonProperty("http_failures")
    private Long httpFailures = 0L;
    @JsonProperty("http_statuses")
    private Set<Integer> httpStatues;
    @JsonProperty("tcp_failures")
    private Long tcpFailures = 0L;
    private Long timeouts = 0L;

    public HealthyCheckUnHealthyStatus() {
    }

    public Long getHttpFailures() {
        return httpFailures;
    }

    public void setHttpFailures(Long httpFailures) {
        this.httpFailures = httpFailures;
    }

    public Set<Integer> getHttpStatues() {
        return httpStatues;
    }

    public void setHttpStatues(Set<Integer> httpStatues) {
        this.httpStatues = httpStatues;
    }

    public Long getTcpFailures() {
        return tcpFailures;
    }

    public void setTcpFailures(Long tcpFailures) {
        this.tcpFailures = tcpFailures;
    }

    public Long getTimeouts() {
        return timeouts;
    }

    public void setTimeouts(Long timeouts) {
        this.timeouts = timeouts;
    }
}
