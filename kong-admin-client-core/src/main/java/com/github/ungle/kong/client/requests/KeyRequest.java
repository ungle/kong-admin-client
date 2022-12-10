package com.github.ungle.kong.client.requests;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ungle.kong.client.model.IdNameRelation;

public class KeyRequest extends Request {
	
	private String name;
	private String kid;
	private String jwk;
	private PEMKeyPair pem;
	private IdNameRelation set;
	private Set<String> tags;
	
	public KeyRequest() {
		super();
	}
	
	public KeyRequest(String kid) {
		super();
		this.kid = kid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKid() {
		return kid;
	}
	public void setKid(String kid) {
		this.kid = kid;
	}
	public String getJwk() {
		return jwk;
	}
	public void setJwk(String jwk) {
		this.jwk = jwk;
	}
	public PEMKeyPair getPem() {
		return pem;
	}
	public void setPem(PEMKeyPair pem) {
		this.pem = pem;
	}
	public IdNameRelation getSet() {
		return set;
	}
	public void setSet(IdNameRelation set) {
		this.set = set;
	}
	public Set<String> getTags() {
		return tags;
	}
	public void setTags(Set<String> tags) {
		this.tags = tags;
	} 
	
	public static class PEMKeyPair{
		@JsonProperty("private_key")
		private String privateKey;
		@JsonProperty("public_key")
		private String publicKey;
		
		public PEMKeyPair() {
			
		}
		
		public String getPrivateKey() {
			return privateKey;
		}
		public void setPrivateKey(String privateKey) {
			this.privateKey = privateKey;
		}
		public String getPublicKey() {
			return publicKey;
		}
		public void setPublicKey(String publicKey) {
			this.publicKey = publicKey;
		}
		
		
	}
	
	

}
