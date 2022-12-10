package org.kastin.kong.client.model;

import org.kastin.kong.client.enums.UpstreamProtocol;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HealthyCheckPassive {

    @JsonProperty("unhealthy")
    private HealthyCheckUnHealthyStatus unhealthy;
    private UpstreamProtocol type = UpstreamProtocol.HTTP;
    private HealthyCheckHealthyStatus healthy;

    public HealthyCheckPassive() {
    }

    public HealthyCheckUnHealthyStatus getUnhealthy() {
        return unhealthy;
    }

    public void setUnhealthy(HealthyCheckUnHealthyStatus unhealthy) {
        this.unhealthy = unhealthy;
    }

    public UpstreamProtocol getType() {
        return type;
    }

    public void setType(UpstreamProtocol type) {
        this.type = type;
    }

    public HealthyCheckHealthyStatus getHealthy() {
        return healthy;
    }

    public void setHealthy(HealthyCheckHealthyStatus healthy) {
        this.healthy = healthy;
    }
}
