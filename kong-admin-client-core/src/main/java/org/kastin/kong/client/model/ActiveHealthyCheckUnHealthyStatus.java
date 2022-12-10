package org.kastin.kong.client.model;

import java.util.Arrays;
import java.util.HashSet;

public class ActiveHealthyCheckUnHealthyStatus extends HealthyCheckUnHealthyStatus {
    private Long interval = 0L;

    public ActiveHealthyCheckUnHealthyStatus() {
    	super();
    	super.setHttpStatues(new HashSet<>(Arrays.asList(429, 404, 500, 501, 502, 503, 504, 505)));
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        if (interval < 0) {
            throw new IllegalArgumentException("interval must bigger than 0");
        }
        this.interval = interval;
    }
}
