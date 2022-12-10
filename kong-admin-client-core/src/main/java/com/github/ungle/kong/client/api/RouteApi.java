package com.github.ungle.kong.client.api;

import com.github.ungle.kong.client.model.ApiDataList;
import com.github.ungle.kong.client.requests.RouteRequest;
import com.github.ungle.kong.client.response.RouteResponse;
import com.github.ungle.kong.client.service.TagQueryBuilder;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * 
 * @author ungle
 *
 */
public interface RouteApi {

    /**
     * 增加一个路由
     *
     * @param routeRequest 路由信息
     * @return 被增加的路由信息
     */
    @RequestLine("POST /routes")
    @Headers("Content-Type: application/json")
    RouteResponse add(RouteRequest routeRequest);


    /**
     * 对某个服务增加路由
     *
     * @param service      服务id或者服务名
     * @param routeRequest 路由信息
     * @return 被增加的路由信息
     */
    @RequestLine("POST /services/{service}/routes")
    @Headers("Content-Type: application/json")
    RouteResponse addByService(@Param("service") String service, RouteRequest routeRequest);

    /**
     * 获取第一页的路由
     *
     * @return 路由列表
     */
    @RequestLine("GET /routes")
    ApiDataList<RouteResponse> find();

    /**
     * 根据偏移量获取路由
     *
     * @param offset 偏移量,当为0时获取第一页，不可为空
     * @return 路由列表
     */
    @RequestLine("GET /routes?offset={offset}")
    ApiDataList<RouteResponse> findByOffset(@Param("offset") String offset);

    /**
     * 通过服务id或者名称查找路由
     *
     * @param service 服务id
     * @return 路由列表
     */
    @RequestLine("GET /services/{service}/routes")
    ApiDataList<RouteResponse> findByService(@Param("service") String service);

    /**
     * 通过路由id或者名称查找路由
     *
     * @param route 路由id
     * @return 路由信息
     */
    @RequestLine("GET /routes/{route}")
    RouteResponse retrieve(@Param("route") String route);

    /**
     * 根据插件id查找路由
     *
     * @param plugin 插件id
     * @return 路由信息
     */
    @RequestLine("GET /plugins/{plugin}/route")
    RouteResponse retrieveByPlugin(@Param("plugin") String plugin);


    /**
     * 根据标签筛选路由
     *
     * @param tagQueryBuilder 标签查询构建
     * @return 路由列表
     */
    @RequestLine("GET /routes?tags={tags}")
    ApiDataList<RouteResponse> findByTag(@Param("tags") TagQueryBuilder tagQueryBuilder);

    /**
     * 根据路由id或者名称创建或更新路由
     *
     * @param route        路由ID或者名称
     * @param routeRequest 路由信息
     * @return 更新后的路由信息
     */
    @RequestLine("PUT /routes/{route}")
    @Headers("Content-Type: application/json")
    RouteResponse createOrUpdate(@Param("route") String route, RouteRequest routeRequest);

    /**
     * 根据插件id创建或更新路由
     *
     * @param plugin       插件id
     * @param routeRequest 路由信息
     * @return 更新后的路由信息
     */
    @RequestLine("PUT /plugins/{plugin}/route")
    @Headers("Content-Type: application/json")
    RouteResponse createOrUpdateByPlugin(@Param("plugin") String plugin, RouteRequest routeRequest);

    /**
     * 根据路由名称或者id更新路由
     *
     * @param route        路由id或路由名称
     * @param routeRequest 路由信息
     * @return 更新后的路由信息
     */
    @RequestLine("PATCH /routes/{route}")
    @Headers("Content-Type: application/json")
    RouteResponse update(@Param("route") String route, RouteRequest routeRequest);

    /**
     * 根据插件id更新路由
     *
     * @param plugin       插件id
     * @param routeRequest 路由信息
     * @return 更新后的路由信息
     */
    @RequestLine("PATCH /plugins/{plugin}/route")
    @Headers("Content-Type: application/json")
    RouteResponse updateByPlugin(@Param("plugin") String plugin, RouteRequest routeRequest);

    /**
     * 删除路由
     *
     * @param route 路由id或者名称
     */
    @RequestLine("DELETE /routes/{route}")
    void delete(@Param("route") String route);

}
