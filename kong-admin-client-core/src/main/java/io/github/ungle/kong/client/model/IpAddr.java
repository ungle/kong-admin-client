package io.github.ungle.kong.client.model;

public class IpAddr {

    private String ip;
    private Integer port;

    public IpAddr() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
