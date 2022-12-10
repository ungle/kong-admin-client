package io.github.ungle.kong.client.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.requests.ConsumerRequest;
import io.github.ungle.kong.client.response.ConsumerResponse;
import io.github.ungle.kong.client.service.TagQueryBuilder;

/**
 * 
 * @author ungle
 *
 */
public interface ConsumerApi {

    /**
     * Create Consumer
     *
     * @param ConsumerRequest consumer info
     * @return ConsumerResponse consumer added
     */
    @RequestLine("POST /consumers")
    @Headers("Content-Type: application/json")
    ConsumerResponse add(ConsumerRequest consumerRequest);

    /**
     * List Consumers
     *
     * @return consumer list
     */
    @RequestLine("GET /consumers")
    ApiDataList<ConsumerResponse> find();

    /**
     * List Consumers by tag
     *
     * @param tagQueryBuilder tag info
     * @return consumer list
     */
    @RequestLine("GET /consumers?tags={tags}")
    ApiDataList<ConsumerResponse> findByTag(@Param("tags") TagQueryBuilder tagQueryBuilder);

    /**
     * List Consumers by offset
     *
     * @param offset offset value
     * @return consumer list
     */
    @RequestLine("GET /consumers?offset={offset}")
    ApiDataList<ConsumerResponse> findByOffset(@Param("offset") String offset);

    /**
     * Retrieve Consumer
     *
     * @param The unique identifier or the username of the Consumer to retrieve
     * @return consumer info
     */
    @RequestLine("GET /consumers/{consumer}")
    ConsumerResponse retrieve(@Param("consumer") String consumer);

    /**
     * Retrieve Consumer Associated to a Specific Plugin
     *
     * @param plugin The unique identifier of the Plugin associated to the Consumer to be retrieved
     * @return consumer info
     */
    @RequestLine("GET /plugins/{plugin}/consumer")
    ConsumerResponse retrieveByPlugin(@Param("plugin") String plugin);

    /**
     * Update Consumer
     *
     * @param consumer        The unique identifier or the username of the Consumer to update
     * @param consumerRequest consumer info
     * @return consumer info after update
     */
    @RequestLine("PATCH /consumers/{consumer}")
    @Headers("Content-Type: application/json")
    ConsumerResponse update(@Param("consumer") String consumer, ConsumerRequest consumerRequest);

    /**
     * Update Consumer Associated to a Specific Plugin
     *
     * @param plugin          The unique identifier of the Plugin associated to the Consumer to be updated
     * @param consumerRequest consumer info
     * @return consumer info after update
     */
    @RequestLine("PATCH /plugins/{plugin}/consumer")
    @Headers("Content-Type: application/json")
    ConsumerResponse updateByPlugin(@Param("plugin") String plugin, ConsumerRequest consumerRequest);

    /**
     * Create Or Update Consumer
     *
     * @param consumer        The unique identifier or the username of the Consumer to create or update
     * @param consumerRequest consumer info
     * @return consumer info after update or insert
     */
    @RequestLine("PUT /consumers/{consumer}")
    @Headers("Content-Type: application/json")
    ConsumerResponse updateOrCreate(@Param("consumer") String consumer, ConsumerRequest consumerRequest);

    /**
     * Create Or Update Consumer Associated to a Specific Plugin
     *
     * @param plugin          The unique identifier of the Plugin associated to the Consumer to be created or updated
     * @param consumerRequest consumer info
     * @return consumer info after update or insert
     */
    @RequestLine("PUT /plugins/{plugin}/consumer")
    @Headers("Content-Type: application/json")
    ConsumerResponse updateOrCreateByPlugin(@Param("plugin") String plugin, ConsumerRequest consumerRequest);

    /**
     * Delete Consumer
     *
     * @param consumer 	The unique identifier or the username of the Consumer to delete
     */
    @RequestLine("DELETE /consumers/{consumer}")
    void delete(@Param("consumer") String consumer);

}
