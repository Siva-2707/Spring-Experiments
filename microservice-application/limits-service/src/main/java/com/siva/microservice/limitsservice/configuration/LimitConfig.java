package com.siva.microservice.limitsservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "limit-service")
@Getter
@Setter
public class LimitConfig {
    private int minimum;
    private int maximum;

}
