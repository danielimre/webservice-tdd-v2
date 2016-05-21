package com.company.webservicetdd.recenthotels.client;

import static java.util.Objects.requireNonNull;

import java.net.URI;
import java.util.Arrays;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.company.webservicetdd.recenthotels.RecentHotels;
import com.company.webservicetdd.recenthotels.RecentHotelsParameter;
import com.company.webservicetdd.recenthotels.RecentHotelsProvider;
import com.google.common.annotations.VisibleForTesting;

/**
 * Client for {@link RecentHotelsProvider} service.
 *
 * @author Daniel_Imre
 */
public class RecentHotelsProviderClient implements RecentHotelsProvider {
    private final URI endpointUri;
    private RestTemplate restTemplate = new RestTemplate();

    public RecentHotelsProviderClient(URI endpointUri) {
        this.endpointUri = requireNonNull(endpointUri);
        restTemplate.setMessageConverters(Arrays.asList(new MappingJackson2HttpMessageConverter()));
    }

    @Override
    public RecentHotels getRecentHotels(RecentHotelsParameter parameters) {
        try {
            return restTemplate.postForEntity(endpointUri, parameters, RecentHotels.class).getBody();
        } catch (Exception e) {
            throw new RecentHotelsClientError("Cannot retrieve recent hotels", e);
        }
    }

    @VisibleForTesting
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
