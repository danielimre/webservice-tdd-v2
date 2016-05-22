package com.company.webservicetdd.recenthotels.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.company.webservicetdd.recenthotels.RecentHotels;
import com.company.webservicetdd.recenthotels.web.RecentHotelsProviderController;

/**
 * Configuration of the {@link com.company.webservicetdd.recenthotels.RecentHotelsProvider} endpoint.
 *
 * @author Daniel_Imre
 */
@Configuration
@EnableWebMvc
public class RecentHotelsProviderWebConfiguration {
    @Bean
    public RecentHotelsProviderController recentHotelsProviderController() {
        return new RecentHotelsProviderController(parameters -> RecentHotels.empty());
    }
}
