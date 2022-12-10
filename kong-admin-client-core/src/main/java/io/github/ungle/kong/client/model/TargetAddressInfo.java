package io.github.ungle.kong.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TargetAddressInfo {

    @JsonProperty("port")
    private int port;

    @JsonProperty("ip")
    private String ip;

    @JsonProperty("health")
    private String health;

    @JsonProperty("weight")
    private int weight;

    public TargetAddressInfo() {
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}