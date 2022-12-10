package io.github.ungle.kong.client.model;

public class HealthCheck {
	private HealthyCheckActive active;
	private HealthyCheckPassive passive;
	private Integer threshold = 0;

	public HealthCheck() {
	}

	public Integer getThreshold() {
		return threshold;
	}

	public void setThreshold(Integer threshold) {
		this.threshold = threshold;
	}

	public HealthyCheckActive getActive() {
		return active;
	}

	public void setActive(HealthyCheckActive active) {
		this.active = active;
	}

	public HealthyCheckPassive getPassive() {
		return passive;
	}

	public void setPassive(HealthyCheckPassive passive) {
		this.passive = passive;
	}
}
