package org.kastin.kong.client.model;

import java.util.Arrays;
import java.util.HashSet;

public class ActiveHealthyCheckHealthyStatus extends HealthyCheckHealthyStatus {
    private Long interval = 0L;

    public ActiveHealthyCheckHealthyStatus() {
    	super();
    	super.setHttpStatuses(new HashSet<>(Arrays.asList(200, 302)));
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        if (interval < 0) {
            throw new IllegalArgumentException("interval需大于0");
        }
        this.interval = interval;
    }
}
