package io.github.ungle.kong.client.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ProtocolEnum {
    /**
     * kong supported protocols
     */
    @JsonProperty("grpc")
    GRPC,

    @JsonProperty("grpcs")
    GRPCS,

    @JsonProperty("http")
    HTTP,

    @JsonProperty("https")
    HTTPS,

    @JsonProperty("tcp")
    TCP,

    @JsonProperty("tls")
    TLS,

    @JsonProperty("udp")
    UDP;

}
