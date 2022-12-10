package com.github.ungle.kong.client.feignclient.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author ungle
 */
public class KeyAuthInterceptor implements RequestInterceptor {

    private final String headerName;
    private final String apiKey;

    public KeyAuthInterceptor(String headerName, String apiKey) {
        this.apiKey = apiKey;
        this.headerName = headerName;

    }

    @Override
    public void apply(RequestTemplate template) {
        template.header(headerName, apiKey);
    }
}
