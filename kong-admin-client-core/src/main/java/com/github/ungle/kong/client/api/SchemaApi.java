package com.github.ungle.kong.client.api;

import com.github.ungle.kong.client.requests.PluginRequest;
import com.github.ungle.kong.client.requests.Request;
import com.github.ungle.kong.client.response.EntitySchemaResponse;
import com.github.ungle.kong.client.response.MessageResponse;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

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
