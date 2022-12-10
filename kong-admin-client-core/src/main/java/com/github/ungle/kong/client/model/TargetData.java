package com.github.ungle.kong.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TargetData {

    @JsonProperty("nodeWeight")
    private int nodeWeight;

    @JsonProperty("addresses")
    private List<TargetAddressInfo> addresses;

    @JsonProperty("port")
    private int port;

    @JsonProperty("host")
    private String host;

    @JsonProperty("dns")
    private String dns;

    @JsonProperty("weight")
    private TargetWeightInfo weight;

    public TargetData() {
    }

    public int getNodeWeight() {
        return nodeWeight;
    }

    public void setNodeWeight(int nodeWeight) {
        this.nodeWeight = nodeWeight;
    }

    public List<TargetAddressInfo> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<TargetAddressInfo> addresses) {
        this.addresses = addresses;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    public TargetWeightInfo getWeight() {
        return weight;
    }

    public void setWeight(TargetWeightInfo weight) {
        this.weight = weight;
    }
}