package com.company.webservicetdd.recenthotels.client;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.net.URI;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.company.webservicetdd.hotel.HotelId;
import com.company.webservicetdd.recenthotels.RecentHotel;
import com.company.webservicetdd.recenthotels.RecentHotels;
import com.company.webservicetdd.recenthotels.RecentHotelsParameter;
import com.company.webservicetdd.user.User;
import com.google.common.collect.ImmutableList;

/**
 * Unit test for {@link RecentHotelsProviderClient}.
 *
 * @author Daniel_Imre
 */
public class RecentHotelsProviderClientTest {
    private static final URI ENDPOINT_URI = URI.create("http://base/service");
    private RecentHotelsProviderClient client;
    @Mock
    private RestTemplate restTemplate;

    @Before
    public void initContext() {
        initMocks(this);
        client = new RecentHotelsProviderClient(ENDPOINT_URI);
        client.setRestTemplate(restTemplate);
    }

    @Test
    public void shouldInvokeRemoteServiceUsingPostRequest() {
        when(restTemplate.postForEntity(isA(URI.class), isA(RecentHotelsParameter.class), eq(RecentHotels.class))).thenReturn(
                new ResponseEntity<>(expectedRecentHotels(), HttpStatus.OK));

        RecentHotels result = client.getRecentHotels(recentHotelsParameter());

        assertThat(result, is(expectedRecentHotels()));
        verify(restTemplate, times(1)).postForEntity(eq(ENDPOINT_URI), eq(recentHotelsParameter()), eq(RecentHotels.class));
    }

    @Test(expected = RecentHotelsClientError.class)
    public void shouldThrowCustomExceptionInCaseOfHttpException() {
        when(restTemplate.postForEntity(isA(URI.class), isA(RecentHotelsParameter.class), eq(RecentHotels.class))).thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));

        client.getRecentHotels(recentHotelsParameter());
    }

    private RecentHotelsParameter recentHotelsParameter() {
        return RecentHotelsParameter.builder().forUser(User.of(1L)).withLocale(Locale.CHINESE).limit(2).build();
    }

    private RecentHotels expectedRecentHotels() {
        return new RecentHotels(ImmutableList.of(new RecentHotel(HotelId.of(1L), "name")));
    }
}
