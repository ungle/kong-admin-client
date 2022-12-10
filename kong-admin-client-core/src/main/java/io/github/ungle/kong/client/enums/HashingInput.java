package io.github.ungle.kong.client.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum HashingInput {
    @JsonProperty("none")
    NONE,
    @JsonProperty("consumer")
    CONSUMER,
    @JsonProperty("ip")
    IP,
    @JsonProperty("header")
    HEADER,
    @JsonProperty("cookie")
    COOKIE,
    @JsonProperty("path")
    PATH,
    @JsonProperty("query_arg")
    QUERY_ARG,
    @JsonProperty("uri_capture")
    URI_CAPTURE;
}
