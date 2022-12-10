package com.github.ungle.kong.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * @author ungle
 * 
 */
public class NodeInformationResponse {

	@JsonProperty("hostname")
	private String hostname;

	private Timers timers;

	private Pids pids;

	@JsonProperty("configuration") private Map<String, Object> configuration;

	@JsonProperty("plugins")
	private Plugins plugins;

	@JsonProperty("tagline")
	private String tagline;

	@JsonProperty("version")
	private String version;

	@JsonProperty("node_id")
	private String nodeId;

	@JsonProperty("lua_version")
	private String luaVersion;

	public NodeInformationResponse() {
	}

	public Timers getTimers() {
		return timers;
	}

	public void setTimers(Timers timers) {
		this.timers = timers;
	}

	public Pids getPids() {
		return pids;
	}

	public void setPids(Pids pids) {
		this.pids = pids;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public Map<String, Object> getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Map<String, Object> configuration) {
		this.configuration = configuration;
	}

	public Plugins getPlugins() {
		return plugins;
	}

	public void setPlugins(Plugins plugins) {
		this.plugins = plugins;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getLuaVersion() {
		return luaVersion;
	}

	public void setLuaVersion(String luaVersion) {
		this.luaVersion = luaVersion;
	}

	public static class Pids {
		public Integer master;
		public List<Integer> workers;

		public Pids() {
		}

		public Integer getMaster() {
			return master;
		}

		public void setMaster(Integer master) {
			this.master = master;
		}

		public List<Integer> getWorkers() {
			return workers;
		}

		public void setWorkers(List<Integer> workers) {
			this.workers = workers;
		}

	}

	public static class Timers {
		public Integer pending;
		public Integer running;

		public Timers() {
		}

		public Integer getPending() {
			return pending;
		}

		public void setPending(Integer pending) {
			this.pending = pending;
		}

		public Integer getRunning() {
			return running;
		}

		public void setRunning(Integer running) {
			this.running = running;
		}

	}

	public static class Plugins {

		@JsonProperty("available_on_server")
		private Map<String, Object> availableOnServer;

		@JsonProperty("enabled_in_cluster")
		private List<Object> enabledInCluster;

		public Plugins() {
		}

		public Map<String, Object> getAvailableOnServer() {
			return availableOnServer;
		}

		public void setAvailableOnServer(Map<String, Object> availableOnServer) {
			this.availableOnServer = availableOnServer;
		}

		public List<Object> getEnabledInCluster() {
			return enabledInCluster;
		}

		public void setEnabledInCluster(List<Object> enabledInCluster) {
			this.enabledInCluster = enabledInCluster;
		}
	}
}