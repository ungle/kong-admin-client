package org.kastin.kong.starter.configuration.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.kastin.kong.client.api.InformationApi;
import org.kastin.kong.client.feignclient.KongClientFactory;
import org.kastin.kong.client.response.NodeStatusResponse;
import org.kastin.kong.starter.configuration.KongAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

public class KongAutoConfigTest {
    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(KongAutoConfiguration.class));
    @Test
    public void defaultConfigTest() throws Exception {
        this.contextRunner.withPropertyValues("kong.client.targets:http://127.0.0.1:8001")

                .run(context -> {
                    KongClientFactory bean = context.getBean(KongClientFactory.class);
                    InformationApi api = bean.getApiInstance(InformationApi.class);
                    NodeStatusResponse result = api.getNodeStatus();
                    assertTrue(result.getDatabase().getReachable());
                });
    }
}
