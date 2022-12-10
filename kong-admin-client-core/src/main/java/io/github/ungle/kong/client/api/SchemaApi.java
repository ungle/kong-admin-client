package io.github.ungle.kong.client.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.ungle.kong.client.requests.PluginRequest;
import io.github.ungle.kong.client.requests.Request;
import io.github.ungle.kong.client.response.EntitySchemaResponse;
import io.github.ungle.kong.client.response.MessageResponse;

public interface SchemaApi {
	
	@RequestLine("POST /schemas/{entity}/validate")
	@Headers("Content-Type: application/json")
	MessageResponse validateEntity(@Param("entity") String entity, Request request);
	
	@RequestLine("GET /schemas/{entity}")
	EntitySchemaResponse getEntitySchema(@Param("entity") String entity);
	
	@RequestLine("GET /schemas/plugins/{plugin}")
	EntitySchemaResponse getPluginSchema(@Param("plugin") String pluginName);
	
	@RequestLine("POST /schemas/plugins/validate")
	@Headers("Content-Type: application/json")
	MessageResponse validatePlugin(PluginRequest request);
	
	

}
