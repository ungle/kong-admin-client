package io.github.ungle.kong.client.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import io.github.ungle.kong.client.api.InformationApi;
import io.github.ungle.kong.client.feignclient.KongClientFactory;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.response.NodeInformationResponse;
import io.github.ungle.kong.client.response.NodeStatusResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

/**
 * @author ungle
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InfomationApiTest {
    InformationApi informationApi;

    @BeforeAll
    public void initTest() {
        KongClientFactory kongClientFactory = KongClientFactory.builder()
                .targets(Arrays.asList("http://127.0.0.1:8001")).build();
        informationApi = kongClientFactory.getApiInstance(InformationApi.class);
    }

    @Test
    public void find() throws Exception {
        NodeStatusResponse result1 = informationApi.getNodeStatus();
        NodeInformationResponse result2 = informationApi.getNodeInfo();
        ApiDataList<String> endpoints = informationApi.getAvailableEndpoints();
        assertTrue(endpoints.getData().contains("/services"));
        assertTrue(result1.getDatabase().getReachable());
        assertEquals("Welcome to kong",result2.getTagline());
    }
}
