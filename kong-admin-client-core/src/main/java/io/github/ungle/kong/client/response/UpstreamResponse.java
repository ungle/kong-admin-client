package io.github.ungle.kong.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.enums.BalancingAlgorithm;
import io.github.ungle.kong.client.enums.HashingInput;
import io.github.ungle.kong.client.model.HealthCheck;
import io.github.ungle.kong.client.model.IdNameRelation;

import java.util.Set;

public class UpstreamResponse {

	private String id;

	@JsonProperty("created_at")
	private Long createdAt;

	@JsonProperty("name")
	private String name;

	@JsonProperty("algorithm")
	private BalancingAlgorithm algorithm;

	@JsonProperty("hash_on")
	private HashingInput hashOn;

	@JsonProperty("hash_fallback")
	private HashingInput hashFallback;

	@JsonProperty("hash_on_header")
	private String hashOnHeader;

	@JsonProperty("hash_fallback_header")
	private String hashFallbackHeader;

	@JsonProperty("hash_on_cookie")
	private String hashOnCookie;

	@JsonProperty("hash_on_cookie_path")
	private String hashOnCookiePath;

	@JsonProperty("hash_on_query_arg")
	private String hashOnQueryArg;

	@JsonProperty("hash_fallback_query_arg")
	private String hashFallbackQueryArg;

	@JsonProperty("hash_on_uri_capture")
	private String hashOnURICapture;

	@JsonProperty("hash_fallback_uri_capture")
	private String hashFallbackURICapture;

	@JsonProperty("slots")
	private Integer slots;

	@JsonProperty("tags")
	private Set<String> tags;

	@JsonProperty("host_header")
	private String hostHeader;

	@JsonProperty("client_certificate")
	private IdNameRelation clientCertificateId;

	@JsonProperty("use_srv_name")
	private Boolean useSRVName;

	private HealthCheck healthchecks;

	public UpstreamResponse() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public String getHashOnCookie() {
		return hashOnCookie;
	}

	public void setHashOnCookie(String hashOnCookie) {
		this.hashOnCookie = hashOnCookie;
	}

	public String getHashOnQueryArg() {
		return hashOnQueryArg;
	}

	public void setHashOnQueryArg(String hashOnQueryArg) {
		this.hashOnQueryArg = hashOnQueryArg;
	}

	public String getHashFallbackQueryArg() {
		return hashFallbackQueryArg;
	}

	public void setHashFallbackQueryArg(String hashFallbackQueryArg) {
		this.hashFallbackQueryArg = hashFallbackQueryArg;
	}

	public String getHashOnURICapture() {
		return hashOnURICapture;
	}

	public void setHashOnURICapture(String hashOnURICapture) {
		this.hashOnURICapture = hashOnURICapture;
	}

	public String getHashFallbackURICapture() {
		return hashFallbackURICapture;
	}

	public void setHashFallbackURICapture(String hashFallbackURICapture) {
		this.hashFallbackURICapture = hashFallbackURICapture;
	}

	public String getHostHeader() {
		return hostHeader;
	}

	public void setHostHeader(String hostHeader) {
		this.hostHeader = hostHeader;
	}

	public IdNameRelation getClientCertificateId() {
		return clientCertificateId;
	}

	public void setClientCertificateId(IdNameRelation clientCertificateId) {
		this.clientCertificateId = clientCertificateId;
	}

	public Boolean getUseSRVName() {
		return useSRVName;
	}

	public void setUseSRVName(Boolean useSRVName) {
		this.useSRVName = useSRVName;
	}

	public HealthCheck getHealthchecks() {
		return healthchecks;
	}

	public void setHealthchecks(HealthCheck healthchecks) {
		this.healthchecks = healthchecks;
	}

	public HashingInput getHashFallback() {
		return hashFallback;
	}

	public void setHashFallback(HashingInput hashFallback) {
		this.hashFallback = hashFallback;
	}

	public Integer getSlots() {
		return slots;
	}

	public void setSlots(Integer slots) {
		this.slots = slots;
	}

	public HashingInput getHashOn() {
		return hashOn;
	}

	public void setHashOn(HashingInput hashOn) {
		this.hashOn = hashOn;
	}

	public String getHashOnHeader() {
		return hashOnHeader;
	}

	public void setHashOnHeader(String hashOnHeader) {
		this.hashOnHeader = hashOnHeader;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHashOnCookiePath() {
		return hashOnCookiePath;
	}

	public void setHashOnCookiePath(String hashOnCookiePath) {
		this.hashOnCookiePath = hashOnCookiePath;
	}

	public String getHashFallbackHeader() {
		return hashFallbackHeader;
	}

	public void setHashFallbackHeader(String hashFallbackHeader) {
		this.hashFallbackHeader = hashFallbackHeader;
	}

	public BalancingAlgorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(BalancingAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
}