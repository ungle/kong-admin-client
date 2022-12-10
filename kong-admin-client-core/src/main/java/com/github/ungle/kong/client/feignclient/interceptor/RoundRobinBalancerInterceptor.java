package com.github.ungle.kong.client.feignclient.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ungle
 */
public class RoundRobinBalancerInterceptor implements RequestInterceptor {
    private static final Logger log = LoggerFactory.getLogger(RoundRobinBalancerInterceptor.class);

    private List<String> targets;
    private AtomicInteger currentIndex = new AtomicInteger(0);

    private RoundRobinBalancerInterceptor() {
    }

    public static RoundRobinBalancerInterceptor build(List<String> targets) {
        RoundRobinBalancerInterceptor interceptor = new RoundRobinBalancerInterceptor();
        interceptor.targets = targets;
        return interceptor;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (targets == null || targets.isEmpty()) {
            throw new IllegalArgumentException("kong target is empty");
        }
        int nextServerIndex = getNextTargetIndex(targets.size());
        log.debug("choose target {}", targets.get(nextServerIndex));
        requestTemplate.target(targets.get(nextServerIndex));
    }

    private int getNextTargetIndex(int targetSize) {
        for (; ; ) {
            int current = currentIndex.get();
            int next = (current + 1) % targetSize;
            if (currentIndex.compareAndSet(current, next)) {
                return next;
            }
        }
    }

}
