package com.github.ungle.kong.client.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ungle
 */
public enum BalancingAlgorithm {
    /**
     * 轮询
     */
    @JsonProperty("round-robin")
    ROUND_ROBIN,
    /**
     * 哈希
     */
    @JsonProperty("consistent-hashing")
    CONSISTENT_HASHING,
    /**
     * 最少连接
     */
    @JsonProperty("least-connections")
    LEAST_CONNECTIONS
}
