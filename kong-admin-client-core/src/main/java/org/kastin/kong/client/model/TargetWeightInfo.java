package org.kastin.kong.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TargetWeightInfo {

    @JsonProperty("total")
    private int total;

    @JsonProperty("unavailable")
    private int unavailable;

    @JsonProperty("available")
    private int available;

    public TargetWeightInfo() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(int unavailable) {
        this.unavailable = unavailable;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}