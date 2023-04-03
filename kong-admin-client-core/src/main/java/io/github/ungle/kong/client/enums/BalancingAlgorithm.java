package io.github.ungle.kong.client.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ungle
 */
public enum BalancingAlgorithm {
    /**
     * round-robin
     */
    @JsonProperty("round-robin")
    ROUND_ROBIN,
    /**
     * hash
     */
    @JsonProperty("consistent-hashing")
    CONSISTENT_HASHING,
    /**
     * least-connections
     */
    @JsonProperty("least-connections")
    LEAST_CONNECTIONS,
    
    /*
     * introduced in 3.2.x, choose target base on its latency
     */
    @JsonProperty("latency")
    LATENCY
}
