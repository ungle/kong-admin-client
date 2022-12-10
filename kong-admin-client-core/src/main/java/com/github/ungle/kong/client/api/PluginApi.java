package com.github.ungle.kong.client.api;

import com.github.ungle.kong.client.model.ApiDataList;
import com.github.ungle.kong.client.requests.PluginRequest;
import com.github.ungle.kong.client.response.PluginResponse;
import com.github.ungle.kong.client.service.TagQueryBuilder;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 *
 * @author ungle
 */
public interface PluginApi {

	/**
	 * Create Plugin
	 *
	 * @param pluginRequest plugin info
	 * @return plugin added
	 */
	@RequestLine("POST /plugins")
	@Headers("Content-Type: application/json")
	PluginResponse add(PluginRequest pluginRequest);

	/**
	 * Create Plugin Associated to a Specific Route
	 *
	 * @param route         The unique identifier or the name attribute of the Route
	 *                      that should be associated to the newly-created Plugin
	 * @param pluginRequest plugin info
	 * @return plugin added
	 */
	@RequestLine("POST /routes/{route}/plugins")
	@Headers("Content-Type: application/json")
	PluginResponse addByRoute(@Param("route") String route, PluginRequest pluginRequest);

	/**
	 * Create Plugin Associated to a Specific Service
	 *
	 * @param service       The unique identifier or the name attribute of the
	 *                      Service that should be associated to the newly-created
	 *                      Plugin.
	 * @param pluginRequest plugin info
	 * @return plugin added
	 */
	@RequestLine("POST /services/{service}/plugins")
	@Headers("Content-Type: application/json")
	PluginResponse addByService(@Param("service") String service, PluginRequest pluginRequest);

	/**
	 * Create Plugin Associated to a Specific Consumer
	 *
	 * @param consumerId    The unique identifier or the name attribute of the
	 *                      Consumer that should be associated to the newly-created
	 *                      Plugin.
	 * @param pluginRequest plugin info
	 * @return plugin added
	 */
	@RequestLine("POST /consumers/{consumer}/plugins")
	@Headers("Content-Type: application/json")
	PluginResponse addByConsumer(@Param("consumer") String consumer, PluginRequest pluginRequest);

	/**
	 * List All Plugins
	 *
	 * @return plugin list
	 */
	@RequestLine("GET /plugins")
	ApiDataList<PluginResponse> find();

	/**
	 * List Plugins by offset
	 *
	 * @param offset offset
	 * @return plugin list
	 */
	@RequestLine("GET /plugins?offset={offset}")
	ApiDataList<PluginResponse> findByOffset(@Param("offset") String offset);

	/**
	 * List Plugins Associated to a Specific Route
	 *
	 * @param route The unique identifier or the name attribute of the Route whose
	 *              Plugins are to be retrieved. When using this endpoint, only
	 *              Plugins associated to the specified Route will be listed
	 * @return plugin list
	 */
	@RequestLine("GET /routes/{route}/plugins")
	ApiDataList<PluginResponse> findByRoute(@Param("route") String route);

	/**
	 * List Plugins Associated to a Specific Service
	 *
	 * @param service The unique identifier or the name attribute of the Service
	 *                whose Plugins are to be retrieved. When using this endpoint,
	 *                only Plugins associated to the specified Service will be
	 *                listed.
	 * @return plugin list
	 */
	@RequestLine("GET /services/{service}/plugins")
	ApiDataList<PluginResponse> findByService(@Param("service") String service);

	/**
	 * List Plugins Associated to a Specific Consumer
	 *
	 * @param consumer The unique identifier or the name attribute of the Consumer
	 *                 whose Plugins are to be retrieved. When using this endpoint,
	 *                 only Plugins associated to the specified Consumer will be
	 *                 listed
	 * @return plugin list
	 */
	@RequestLine("GET /consumers/{consumer}/plugins")
	ApiDataList<PluginResponse> findByConsumer(@Param("consumer") String consumer);

	/**
	 * List Plugins via tags
	 *
	 * @param tagQueryBuilder tagQuery
	 * @return plugin list
	 */
	@RequestLine("GET /plugins?tags={tags}")
	ApiDataList<PluginResponse> findByTag(@Param("tags") TagQueryBuilder tagQueryBuilder);

	/**
	 * Retrieve Plugin
	 *
	 * @param pluginId The unique identifier of the Plugin to retrieve.
	 * @return plugin info
	 */
	@RequestLine("GET /plugins/{plugin_id}")
	PluginResponse retrieve(@Param("plugin_id") String pluginId);

	/**
	 * Retrieve Plugin Associated to a Specific Route
	 *
	 * @param route    The unique identifier or the name of the Route to retrieve.
	 * @param pluginId The unique identifier of the Plugin to retrieve.
	 * @return plugin info
	 */
	@RequestLine("GET /routes/{route}/{plugin_id}")
	PluginResponse retrieveByRoute(@Param("route") String route, @Param("plugin_id") String pluginId);

	/**
	 * Retrieve Plugin Associated to a Specific Service
	 * 
	 * @param service  The unique identifier or the name of the Service to retrieve
	 * @param pluginId The unique identifier of the Plugin to retrieve
	 * @return plugin info
	 */
	@RequestLine("GET /services/{service}/plugins/{plugin_id}")
	PluginResponse retrieveByService(@Param("service") String service, @Param("plugin_id") String pluginId);

	/**
	 * Retrieve Plugin Associated to a Specific Consumer
	 * 
	 * @param consumer The unique identifier or the username of the Consumer to
	 *                 retrieve
	 * @param pluginId The unique identifier of the Plugin to retrieve
	 * @return plugin info
	 */
	@RequestLine("GET /consumers/{consumer}/plugins/{plugin_id}")
	PluginResponse retrieveByConsumer(@Param("consumer") String consumer, @Param("plugin_id") String pluginId);

	/**
	 * Update Plugin
	 *
	 * @param pluginId      The unique identifier of the Plugin to update.
	 * @param pluginRequest plugin info
	 * @return updated plugin info
	 */
	@RequestLine("PATCH /plugins/{plugin_id}")
	@Headers("Content-Type: application/json")
	PluginResponse update(@Param("plugin_id") String pluginId, PluginRequest pluginRequest);

	/**
	 * Update Plugin Associated to a Specific Route
	 *
	 * @param route         The unique identifier or the name of the Route to
	 *                      retrieve.
	 * @param pluginId      The unique identifier of the Plugin to retrieve.
	 * @param pluginRequest plugin info
	 * @return updated plugin info
	 */
	@RequestLine("PATCH /routes/{route}/{plugin_id}")
	@Headers("Content-Type: application/json")
	PluginResponse updateByRoute(@Param("route") String route, @Param("plugin_id") String pluginId,
			PluginRequest pluginRequest);

	/**
	 * Update Plugin Associated to a Specific Service
	 * 
	 * @param service       The unique identifier or the name of the Service to
	 *                      retrieve
	 * @param pluginId      The unique identifier of the Plugin to retrieve
	 * @param pluginRequest plugin info
	 * @return updated plugin info
	 */
	@RequestLine("PATCH /services/{service}/plugins/{plugin_id}")
	@Headers("Content-Type: application/json")
	PluginResponse updateByService(@Param("service") String service, @Param("plugin_id") String pluginId,
			PluginRequest pluginRequest);

	/**
	 * Update Plugin Associated to a Specific Consumer
	 * 
	 * @param consumer      The unique identifier or the username of the Consumer to
	 *                      retrieve
	 * @param pluginId      The unique identifier of the Plugin to retrieve
	 * @param pluginRequest plugin info
	 * @return updated plugin info
	 */
	@RequestLine("PATCH /consumers/{consumer}/plugins/{plugin_id}")
	@Headers("Content-Type: application/json")
	PluginResponse updateByConsumer(@Param("consumer") String consumer, @Param("plugin_id") String pluginId,
			PluginRequest pluginRequest);

	/**
	 * Create Or Update Plugin
	 *
	 * @param pluginId      The unique identifier of the Plugin to retrieve.
	 * @param pluginRequest plugin info
	 * @return created or updated plugin info
	 */
	@RequestLine("PUT /plugins/{plugin_id}")
	@Headers("Content-Type: application/json")
	PluginResponse updateOrCreate(@Param("plugin_id") String pluginId, PluginRequest pluginRequest);

	/**
	 * Create Or Update Plugin Associated to a Specific Route
	 *
	 * @param route         The unique identifier or the name of the Route to
	 *                      retrieve.
	 * @param pluginId      The unique identifier of the Plugin to retrieve.
	 * @param pluginRequest plugin info
	 * @return created or updated plugin info
	 */
	@RequestLine("PUT /routes/{route}/{plugin_id}")
	@Headers("Content-Type: application/json")
	PluginResponse updateOrCreateByRoute(@Param("route") String route, @Param("plugin_id") String pluginId,
			PluginRequest pluginRequest);

	/**
	 * Create Or Update Plugin Associated to a Specific Service
	 * 
	 * @param service       The unique identifier or the name of the Service to
	 *                      retrieve
	 * @param pluginId      The unique identifier of the Plugin to retrieve
	 * @param pluginRequest plugin info
	 * @return created or updated plugin info
	 */
	@RequestLine("PUT /services/{service}/plugins/{plugin_id}")
	@Headers("Content-Type: application/json")
	PluginResponse updateOrCreateByService(@Param("service") String service, @Param("plugin_id") String pluginId,
			PluginRequest pluginRequest);

	/**
	 * Create Or Update Plugin Associated to a Specific Consumer
	 * 
	 * @param consumer      The unique identifier or the username of the Consumer to
	 *                      retrieve
	 * @param pluginId      The unique identifier of the Plugin to retrieve
	 * @param pluginRequest plugin info
	 * @return created or updated plugin info
	 */
	@RequestLine("PUT /consumers/{consumer}/plugins/{plugin_id}")
	@Headers("Content-Type: application/json")
	PluginResponse updateOrCreateByConsumer(@Param("consumer") String consumer, @Param("plugin_id") String pluginId,
			PluginRequest pluginRequest);

	/**
	 * Delete Plugin
	 *
	 * @param pluginId The unique identifier of the Plugin to delete
	 */
	@RequestLine("DELETE /plugins/{plugin_id}")
	void delete(@Param("plugin_id") String pluginId);

	/**
	 * Delete Plugin Associated to a Specific Route
	 *
	 * @param route    The unique identifier or the name of the Route to retrieve.
	 * @param pluginId The unique identifier of the Plugin to retrieve.
	 */
	@RequestLine("DELETE /routes/{route}/{plugin_id}")
	void deleteByRoute(@Param("route") String route, @Param("plugin_id") String pluginId);

	/**
	 * Delete Plugin Associated to a Specific Service
	 * 
	 * @param service  The unique identifier or the name of the Service to retrieve
	 * @param pluginId The unique identifier of the Plugin to retrieve
	 */
	@RequestLine("DELETE /services/{service}/plugins/{plugin_id}")
	void deleteByService(@Param("service") String service, @Param("plugin_id") String pluginId);

	/**
	 * Delete Plugin Associated to a Specific Consumer
	 * 
	 * @param consumer The unique identifier or the username of the Consumer to
	 *                 retrieve
	 * @param pluginId The unique identifier of the Plugin to retrieve
	 */
	@RequestLine("DELETE /consumers/{consumer}/plugins/{plugin_id}")
	void deleteByConsumer(@Param("consumer") String consumer, @Param("plugin_id") String pluginId);

}
