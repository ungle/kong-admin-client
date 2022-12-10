package com.github.ungle.kong.client.api;

import com.github.ungle.kong.client.model.ApiDataList;
import com.github.ungle.kong.client.response.TagResponse;

import feign.Param;
import feign.RequestLine;

/**
 *
 * @author ungle
 */
public interface TagApi {

    /**
     * List All Tags
     *
     * @return a paginated list of all the tags in the system
     */
    @RequestLine("GET /tags")
    ApiDataList<TagResponse> find();

    /**
     * List All Tags by offset
     *
     * @param offset offset
     * @return a paginated list of all the tags in the system
     */
    @RequestLine("GET /tags?offset={offset}")
    ApiDataList<TagResponse> findByOffset(@Param("offset") String offset);

    /**
     * Returns the entities that have been tagged with the specified tag.
     * it does not work in kong 3.1.0, so comment it temperately
     *
     * @param tag tag Name
     * @return tag list
     */
    
    /**
     * @RequestLine("GET /tags/{tag}")
     * ApiDataList<TagResponse> find(@Param("tag") String tag);
     */
    


}
