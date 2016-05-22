package com.company.webservicetdd.recenthotels.web;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.company.webservicetdd.hotel.HotelId;
import com.company.webservicetdd.recenthotels.RecentHotel;
import com.company.webservicetdd.recenthotels.RecentHotels;
import com.company.webservicetdd.recenthotels.RecentHotelsParameter;
import com.company.webservicetdd.recenthotels.RecentHotelsProvider;
import com.company.webservicetdd.user.User;
import com.google.common.collect.ImmutableList;

/**
 * Unit test for {@link RecentHotelsProvider}.
 *
 * @author Daniel_Imre
 */
public class RecentHotelsProviderControllerTest {
    private RecentHotelsProviderController controller;
    @Mock
    private RecentHotelsProvider service;

    @Before
    public void initContext() {
        initMocks(this);
        controller = new RecentHotelsProviderController(service);
    }

    @Test
    public void shouldDelegateCallToService() {
        when(service.getRecentHotels(isA(RecentHotelsParameter.class))).thenReturn(expectedRecentHotelsResult());

        RecentHotels result = controller.getRecentHotels(recentHotelParameters());

        assertThat(result, is(expectedRecentHotelsResult()));
        verify(service).getRecentHotels(eq(recentHotelParameters()));
    }

    private RecentHotelsParameter recentHotelParameters() {
        return RecentHotelsParameter.builder().forUser(User.of(1L)).withLocale(Locale.ENGLISH).limit(2).build();
    }

    private RecentHotels expectedRecentHotelsResult() {
        return new RecentHotels(ImmutableList.of(new RecentHotel(HotelId.of(1L), "somename")));
    }
}
