package io.github.ungle.kong.client.model.plugins.transformation;

import io.github.ungle.kong.client.model.plugins.PluginConfig;

public class GRPCGatewayConfig extends PluginConfig {
	private String proto;

	public GRPCGatewayConfig() {
	}

	public GRPCGatewayConfig(String proto) {
		super();
		this.proto = proto;
	}

	public String getProto() {
		return proto;
	}

}
