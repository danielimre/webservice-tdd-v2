package com.company.webservicetdd.common.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Dependencies of the client which are usually provided by the application instantiating the client.
 *
 * @author Daniel_Imre
 */
public class WebServiceClientExternalDependencies {

    @Bean
    static PropertySourcesPlaceholderConfigurer placeholderResolver() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        Properties properties = new Properties();
        properties.setProperty("WEBSERVICETDD_BASE_URL", "http://localhost:9876");
        configurer.setProperties(properties);
        return configurer;
    }
}
