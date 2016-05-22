package com.company.webservicetdd.recenthotels.service.configuration;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.webservicetdd.recenthotels.service.RecentHotelsService;

/**
 * Service configuration for {@link com.company.webservicetdd.recenthotels.RecentHotelsProvider}.
 *
 * @author Daniel_Imre
 */
@Configuration
public class RecentHotelsProviderServiceConfiguration {
    @Bean
    public RecentHotelsService recentHotelsProviderService() {
        return new RecentHotelsService(ids -> null, (id, locale) -> Optional.empty());
    }
}
