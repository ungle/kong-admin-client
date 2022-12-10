package io.github.ungle.kong.springboot.configuration.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import com.github.ungle.kong.client.api.InformationApi;
import com.github.ungle.kong.client.feignclient.KongClientFactory;
import com.github.ungle.kong.client.response.NodeStatusResponse;

import io.github.ungle.kong.springboot.configuration.KongAutoConfiguration;

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
