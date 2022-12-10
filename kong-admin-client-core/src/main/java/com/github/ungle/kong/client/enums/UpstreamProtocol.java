package com.github.ungle.kong.client.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UpstreamProtocol {
    @JsonProperty("http")
    HTTP,

    @JsonProperty("https")
    HTTPS,

    @JsonProperty("tcp")
    TCP;
}
