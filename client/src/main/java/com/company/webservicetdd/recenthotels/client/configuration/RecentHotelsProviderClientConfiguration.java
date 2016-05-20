package com.company.webservicetdd.recenthotels.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.webservicetdd.recenthotels.RecentHotelsProvider;

/**
 * Client configuration for {@link RecentHotelsProvider}.
 *
 * @author Daniel_Imre
 */
@Configuration
public class RecentHotelsProviderClientConfiguration {

    @Bean
    public RecentHotelsProvider recentHotelsProvider() {
        return new RecentHotelsProvider();
    }
}
