package com.github.ungle.kong.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 
 * @author ungle
 *
 */
public class NodeStatusResponse {

	@JsonProperty("server")
	private Server server;

	@JsonProperty("database")
	private Database database;

	@JsonProperty("memory")
	private Memory memory;

	@JsonProperty("configuration_hash")
	private String configurationHash;

	public NodeStatusResponse() {
	}

	public String getConfigurationHash() {
		return configurationHash;
	}

	public void setConfigurationHash(String configurationHash) {
		this.configurationHash = configurationHash;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	public static class Database {

		@JsonProperty("reachable")
		private Boolean reachable;

		public Database() {
		}

		public Boolean getReachable() {
			return reachable;
		}

		public void setReachable(Boolean reachable) {
			this.reachable = reachable;
		}
	}

	public static class Memory {

		@JsonProperty("workers_lua_vms")
		private List<WorkersLuaVmsItem> workersLuaVms;

		@JsonProperty("lua_shared_dicts")
		private LuaSharedDicts luaSharedDicts;

		public Memory() {
		}

		public List<WorkersLuaVmsItem> getWorkersLuaVms() {
			return workersLuaVms;
		}

		public void setWorkersLuaVms(List<WorkersLuaVmsItem> workersLuaVms) {
			this.workersLuaVms = workersLuaVms;
		}

		public LuaSharedDicts getLuaSharedDicts() {
			return luaSharedDicts;
		}

		public void setLuaSharedDicts(LuaSharedDicts luaSharedDicts) {
			this.luaSharedDicts = luaSharedDicts;
		}
	}

	public static class LuaSharedDicts {

		@JsonProperty("kong_db_cache")
		private KongCacheCapacity kongDbCache;
		@JsonProperty("kong")
		private KongCacheCapacity kong;
		@JsonProperty("kong_locks")
		private KongCacheCapacity kongLocks;
		@JsonProperty("kong_healthchecks")
		private KongCacheCapacity kongHealthchecks;
		@JsonProperty("kong_process_events")
		private KongCacheCapacity kongProcessEvents;
		@JsonProperty("kong_cluster_events")
		private KongCacheCapacity kongClusterEvents;
		@JsonProperty("kong_rate_limiting_counters")
		private KongCacheCapacity kongRateLimitingCounters;
		@JsonProperty("kong_core_db_cache")
		private KongCacheCapacity kongCoreDbCache;
		@JsonProperty("kong_core_db_cache_miss")
		private KongCacheCapacity kongCoreDbCacheMiss;
		@JsonProperty("kong_db_cache_miss")
		private KongCacheCapacity kongDbCacheMiss;
		@JsonProperty("prometheus_metrics")
		private KongCacheCapacity prometheusMetrics;

		public LuaSharedDicts() {
		}

		public KongCacheCapacity getKongLocks() {
			return kongLocks;
		}

		public void setKongLocks(KongCacheCapacity kongLocks) {
			this.kongLocks = kongLocks;
		}

		public KongCacheCapacity getKongHealthchecks() {
			return kongHealthchecks;
		}

		public void setKongHealthchecks(KongCacheCapacity kongHealthchecks) {
			this.kongHealthchecks = kongHealthchecks;
		}

		public KongCacheCapacity getKongProcessEvents() {
			return kongProcessEvents;
		}

		public void setKongProcessEvents(KongCacheCapacity kongProcessEvents) {
			this.kongProcessEvents = kongProcessEvents;
		}

		public KongCacheCapacity getKongClusterEvents() {
			return kongClusterEvents;
		}

		public void setKongClusterEvents(KongCacheCapacity kongClusterEvents) {
			this.kongClusterEvents = kongClusterEvents;
		}

		public KongCacheCapacity getKongRateLimitingCounters() {
			return kongRateLimitingCounters;
		}

		public void setKongRateLimitingCounters(KongCacheCapacity kongRateLimitingCounters) {
			this.kongRateLimitingCounters = kongRateLimitingCounters;
		}

		public KongCacheCapacity getKongCoreDbCache() {
			return kongCoreDbCache;
		}

		public void setKongCoreDbCache(KongCacheCapacity kongCoreDbCache) {
			this.kongCoreDbCache = kongCoreDbCache;
		}

		public KongCacheCapacity getKongCoreDbCacheMiss() {
			return kongCoreDbCacheMiss;
		}

		public void setKongCoreDbCacheMiss(KongCacheCapacity kongCoreDbCacheMiss) {
			this.kongCoreDbCacheMiss = kongCoreDbCacheMiss;
		}

		public KongCacheCapacity getKongDbCacheMiss() {
			return kongDbCacheMiss;
		}

		public void setKongDbCacheMiss(KongCacheCapacity kongDbCacheMiss) {
			this.kongDbCacheMiss = kongDbCacheMiss;
		}

		public KongCacheCapacity getPrometheusMetrics() {
			return prometheusMetrics;
		}

		public void setPrometheusMetrics(KongCacheCapacity prometheusMetrics) {
			this.prometheusMetrics = prometheusMetrics;
		}

		public KongCacheCapacity getKongDbCache() {
			return kongDbCache;
		}

		public void setKongDbCache(KongCacheCapacity kongDbCache) {
			this.kongDbCache = kongDbCache;
		}

		public KongCacheCapacity getKong() {
			return kong;
		}

		public void setKong(KongCacheCapacity kong) {
			this.kong = kong;
		}
	}

	public static class KongCacheCapacity {

		@JsonProperty("allocated_slabs")
		private String allocatedSlabs;

		@JsonProperty("capacity")
		private String capacity;

		public KongCacheCapacity() {
		}

		public String getAllocatedSlabs() {
			return allocatedSlabs;
		}

		public void setAllocatedSlabs(String allocatedSlabs) {
			this.allocatedSlabs = allocatedSlabs;
		}

		public String getCapacity() {
			return capacity;
		}

		public void setCapacity(String capacity) {
			this.capacity = capacity;
		}
	}

	public static class WorkersLuaVmsItem {

		@JsonProperty("http_allocated_gc")
		private String httpAllocatedGc;

		@JsonProperty("pid")
		private Integer pid;

		public WorkersLuaVmsItem() {
		}

		public String getHttpAllocatedGc() {
			return httpAllocatedGc;
		}

		public void setHttpAllocatedGc(String httpAllocatedGc) {
			this.httpAllocatedGc = httpAllocatedGc;
		}

		public Integer getPid() {
			return pid;
		}

		public void setPid(Integer pid) {
			this.pid = pid;
		}
	}

	public static class Server {

		@JsonProperty("connections_handled")
		private Integer connectionsHandled;

		@JsonProperty("connections_writing")
		private Integer connectionsWriting;

		@JsonProperty("connections_accepted")
		private Integer connectionsAccepted;

		@JsonProperty("connections_waiting")
		private Integer connectionsWaiting;

		@JsonProperty("connections_active")
		private Integer connectionsActive;

		@JsonProperty("total_requests")
		private Integer totalRequests;

		@JsonProperty("connections_reading")
		private Integer connectionsReading;

		public Server() {
		}

		public Integer getConnectionsHandled() {
			return connectionsHandled;
		}

		public void setConnectionsHandled(Integer connectionsHandled) {
			this.connectionsHandled = connectionsHandled;
		}

		public Integer getConnectionsWriting() {
			return connectionsWriting;
		}

		public void setConnectionsWriting(Integer connectionsWriting) {
			this.connectionsWriting = connectionsWriting;
		}

		public Integer getConnectionsAccepted() {
			return connectionsAccepted;
		}

		public void setConnectionsAccepted(Integer connectionsAccepted) {
			this.connectionsAccepted = connectionsAccepted;
		}

		public Integer getConnectionsWaiting() {
			return connectionsWaiting;
		}

		public void setConnectionsWaiting(Integer connectionsWaiting) {
			this.connectionsWaiting = connectionsWaiting;
		}

		public Integer getConnectionsActive() {
			return connectionsActive;
		}

		public void setConnectionsActive(Integer connectionsActive) {
			this.connectionsActive = connectionsActive;
		}

		public Integer getTotalRequests() {
			return totalRequests;
		}

		public void setTotalRequests(Integer totalRequests) {
			this.totalRequests = totalRequests;
		}

		public Integer getConnectionsReading() {
			return connectionsReading;
		}

		public void setConnectionsReading(Integer connectionsReading) {
			this.connectionsReading = connectionsReading;
		}
	}
}