package io.github.ungle.kong.client.model.plugins.traffic;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.model.plugins.PluginConfig;
import io.github.ungle.kong.client.service.ValidateUtils;

import java.util.Arrays;
import java.util.Set;

/**
 * @author ungle
 */
public class AclConfig extends PluginConfig {
    private Set<String> allow;
    private Set<String> deny;
    @JsonProperty("hide_groups_header")
    private Boolean hideGroupHeader = true;
    
    
	private AclConfig(Builder builder) {
		super();
		this.allow = builder.allow;
		this.deny = builder.deny;
		this.hideGroupHeader = builder.hideGroupHeader;
	}
	
	
	public Set<String> getAllow() {
		return allow;
	}


	public Set<String> getDeny() {
		return deny;
	}


	public Boolean getHideGroupHeader() {
		return hideGroupHeader;
	}


	public static Builder builder() {
		return new Builder();
	}
	
	public static final class Builder {
		private Set<String> allow;
		private Set<String> deny;
		private Boolean hideGroupHeader;

		private Builder() {
		}

		public Builder withAllow(Set<String> allow) {
			this.allow = allow;
			return this;
		}

		public Builder withDeny(Set<String> deny) {
			this.deny = deny;
			return this;
		}

		public Builder withHideGroupHeader(Boolean hideGroupHeader) {
			this.hideGroupHeader = hideGroupHeader;
			return this;
		}

		public AclConfig build() {
			ValidateUtils.isAllEmpty("one of allow or deny must be specified", Arrays.asList(allow,deny));
			hideGroupHeader = ValidateUtils.defaultIfNull(hideGroupHeader, Boolean.FALSE);
			return new AclConfig(this);
		}
	}



}
