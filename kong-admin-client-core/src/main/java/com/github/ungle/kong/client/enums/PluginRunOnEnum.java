package com.github.ungle.kong.client.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PluginRunOnEnum {
    @JsonProperty("first")
    FIRST,
    @JsonProperty("second")
    SECOND,
    @JsonProperty("all")
    ALL;
}
