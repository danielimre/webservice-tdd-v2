package com.company.webservicetdd.recenthotels.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.company.webservicetdd.recenthotels.RecentHotelsProvider;
import com.company.webservicetdd.recenthotels.service.configuration.RecentHotelsProviderServiceConfiguration;
import com.company.webservicetdd.recenthotels.web.RecentHotelsProviderController;

/**
 * Configuration of the {@link com.company.webservicetdd.recenthotels.RecentHotelsProvider} endpoint.
 *
 * @author Daniel_Imre
 */
@Configuration
@EnableWebMvc
@Import(RecentHotelsProviderServiceConfiguration.class)
public class RecentHotelsProviderWebConfiguration {
    @Bean
    public RecentHotelsProviderController recentHotelsProviderController(RecentHotelsProvider recentHotelsService) {
        return new RecentHotelsProviderController(recentHotelsService);
    }
}
