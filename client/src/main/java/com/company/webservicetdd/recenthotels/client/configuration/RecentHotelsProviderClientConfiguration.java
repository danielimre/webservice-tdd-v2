package com.company.webservicetdd.recenthotels.client.configuration;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.webservicetdd.recenthotels.RecentHotelsProvider;
import com.company.webservicetdd.recenthotels.client.RecentHotelsProviderClient;

/**
 * Client configuration for {@link RecentHotelsProvider}.
 *
 * @author Daniel_Imre
 */
@Configuration
public class RecentHotelsProviderClientConfiguration {
    @Value("${WEBSERVICETDD_BASE_URL}/services/recenthotels")
    private URI endpointUri;

    @Bean
    public RecentHotelsProvider recentHotelsProvider() {
        return new RecentHotelsProviderClient(endpointUri);
    }
}
