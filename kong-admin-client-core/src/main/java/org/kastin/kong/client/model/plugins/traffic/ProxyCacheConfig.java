package org.kastin.kong.client.model.plugins.traffic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.kastin.kong.client.enums.HttpMethod;
import org.kastin.kong.client.model.plugins.PluginConfig;
import org.kastin.kong.client.service.ValidateUtils;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ProxyCacheConfig extends PluginConfig {

	@JsonProperty("response_code")
	private Set<Integer> responseCode;
	@JsonProperty("request_method")
	private Set<HttpMethod> requestMethod;
	@JsonProperty("content_type")
	private Set<String> contentType;
	@JsonProperty("cache_ttl")
	private Integer cacheTTL;
	@JsonProperty("vary_headers")
	private Set<String> varyHeaders;
	@JsonProperty("vary_query_params")
	private Set<String> varyQueryParams;
	@JsonProperty("cache_control")
	private Boolean cacheControl;
	@JsonProperty("storage_ttl")
	private Integer storageTTL;
	private String strategy;
	private MemoryDictionary memory;

	
	private ProxyCacheConfig(Builder builder) {
		super();
		this.responseCode = builder.responseCode;
		this.requestMethod = builder.requestMethod;
		this.contentType = builder.contentType;
		this.cacheTTL = builder.cacheTTL;
		this.varyHeaders = builder.varyHeaders;
		this.varyQueryParams = builder.varyQueryParams;
		this.cacheControl = builder.cacheControl;
		this.storageTTL = builder.storageTTL;
		this.strategy = builder.strategy;
		this.memory = builder.memory;
	}
	
	public Set<Integer> getResponseCode() {
		return responseCode;
	}

	public Set<HttpMethod> getRequestMethod() {
		return requestMethod;
	}

	public Set<String> getContentType() {
		return contentType;
	}

	public Integer getCacheTTL() {
		return cacheTTL;
	}

	public Set<String> getVaryHeaders() {
		return varyHeaders;
	}

	public Set<String> getVaryQueryParams() {
		return varyQueryParams;
	}

	public Boolean getCacheControl() {
		return cacheControl;
	}

	public Integer getStorageTTL() {
		return storageTTL;
	}

	public String getStrategy() {
		return strategy;
	}

	public MemoryDictionary getMemory() {
		return memory;
	}

	public static final class MemoryDictionary {
		@JsonProperty("dictionary_name")
		private String dictionaryName;

		private MemoryDictionary() {
			dictionaryName = "kong_db_cache";
		}

		public MemoryDictionary(String dictionaryName) {
			this.dictionaryName = dictionaryName;
		}

		public String getDictionaryName() {
			return dictionaryName;
		}

		public void setDictionaryName(String dictionaryName) {
			this.dictionaryName = dictionaryName;
		}

	}
	
	public static MemoryDictionary memoryDictionary() {
		return new MemoryDictionary();
	}


	public static Builder builder() {
		return new Builder();
	}
	

	public static final class Builder {
		private Set<Integer> responseCode;
		private Set<HttpMethod> requestMethod;
		private Set<String> contentType;
		private Integer cacheTTL;
		private Set<String> varyHeaders;
		private Set<String> varyQueryParams;
		private Boolean cacheControl;
		private Integer storageTTL;
		private String strategy;
		private MemoryDictionary memory;

		private Builder() {
			
		}

		public Builder withResponseCode(Set<Integer> responseCode) {
			this.responseCode = responseCode;
			return this;
		}

		public Builder withRequestMethod(Set<HttpMethod> requestMethod) {
			this.requestMethod = requestMethod;
			return this;
		}

		public Builder withContentType(Set<String> contentType) {
			this.contentType = contentType;
			return this;
		}

		public Builder withCacheTTL(Integer cacheTTL) {
			this.cacheTTL = cacheTTL;
			return this;
		}

		public Builder withVaryHeaders(Set<String> varyHeaders) {
			this.varyHeaders = varyHeaders;
			return this;
		}

		public Builder withVaryQueryParams(Set<String> varyQueryParams) {
			this.varyQueryParams = varyQueryParams;
			return this;
		}

		public Builder withCacheControl(Boolean cacheControl) {
			this.cacheControl = cacheControl;
			return this;
		}

		public Builder withStorageTTL(Integer storageTTL) {
			this.storageTTL = storageTTL;
			return this;
		}

		public Builder withMemory(MemoryDictionary memory) {
			this.memory = memory;
			return this;
		}

		public ProxyCacheConfig build() {
			responseCode = ValidateUtils.defaultIfNull(responseCode, new HashSet<>(Arrays.asList(200,301,404)));
			requestMethod = ValidateUtils.defaultIfNull(requestMethod,new HashSet<>(Arrays.asList(HttpMethod.GET,HttpMethod.HEAD)));
			contentType = ValidateUtils.defaultIfNull(contentType,new HashSet<>(Arrays.asList("text/plain", "application/json")));
			cacheTTL=ValidateUtils.defaultIfNull(cacheTTL,300);
			cacheControl=ValidateUtils.defaultIfNull(cacheControl,Boolean.FALSE);
			strategy ="memory";
			memory=ValidateUtils.defaultIfNull(memory,ProxyCacheConfig.memoryDictionary());
			return new ProxyCacheConfig(this);
		}
	}

}
