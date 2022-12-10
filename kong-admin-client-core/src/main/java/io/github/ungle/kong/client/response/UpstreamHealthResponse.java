package io.github.ungle.kong.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpstreamHealthResponse {
	private UpstreamHealth data;
	private String next;

	@JsonProperty("node_id")
	private String nodeId;

	public UpstreamHealthResponse() {
	}

	public UpstreamHealth getData() {
		return data;
	}

	public void setData(UpstreamHealth data) {
		this.data = data;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public static class UpstreamHealth {
		private String id;
		private String health;

		public UpstreamHealth() {

		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getHealth() {
			return health;
		}

		public void setHealth(String health) {
			this.health = health;
		}

	}

}
