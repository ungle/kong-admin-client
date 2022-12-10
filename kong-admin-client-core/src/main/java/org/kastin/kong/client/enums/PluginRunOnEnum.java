package org.kastin.kong.client.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PluginRunOnEnum {
    @JsonProperty("first")
    FIRST,
    @JsonProperty("second")
    SECOND,
    @JsonProperty("all")
    ALL;
}
