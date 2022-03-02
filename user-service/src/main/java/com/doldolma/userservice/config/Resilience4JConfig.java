package com.doldolma.userservice.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import java.time.Duration;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Resilience4JConfig {

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> globalCustomConfiguration() {
        /**
         *  공식문서 : https://resilience4j.readme.io/docs/circuitbreaker
         *  CircuitBreakerConfig : 회로차단설정
         *  TimeLimiterConfig    : 타임아웃설정
         *  RateLimiterRegistry  : 시간당 요청량 조절
         *  RetryConfig          : 재시도 설정
         *  BulkheadRegistry     : 동시 실행 수 제한 설정
         *
         * */
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
            .failureRateThreshold(3)                          // 실패율 임계값
            .waitDurationInOpenState(Duration.ofMillis(1000)) // 개방에서 반개방으로 가기전에 대기시간
            .slidingWindowType(SlidingWindowType.COUNT_BASED) // 윈도우 유형, COUNT_BASED=카운트기반, Time_BASED=시간기반
            .slidingWindowSize(2)                             // 회로가 닫힐때 결과 기록하는 윈도우 사이즈
            .build();

        TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom()
            .timeoutDuration(Duration.ofSeconds(3)).build();

        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
            .timeLimiterConfig(timeLimiterConfig)
            .circuitBreakerConfig(circuitBreakerConfig)
            .build());
    }
}
