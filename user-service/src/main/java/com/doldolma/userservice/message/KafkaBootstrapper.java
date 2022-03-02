package com.doldolma.userservice.message;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class KafkaBootstrapper {
    @Value("${spring.kafka.bootstrap-servers}")
    private String server;
}
