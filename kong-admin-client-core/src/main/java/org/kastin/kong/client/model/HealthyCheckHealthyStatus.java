package org.kastin.kong.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class HealthyCheckHealthyStatus {

    @JsonProperty("successes")
    private int successes = 0;

    @JsonProperty("http_statuses")
    private Set<Integer> httpStatuses;

    public HealthyCheckHealthyStatus() {
    }

    public int getSuccesses() {
        return successes;
    }

    public void setSuccesses(int successes) {
        this.successes = successes;
    }

    public Set<Integer> getHttpStatuses() {
        return httpStatuses;
    }

    public void setHttpStatuses(Set<Integer> httpStatuses) {
        this.httpStatuses = httpStatuses;
    }
}