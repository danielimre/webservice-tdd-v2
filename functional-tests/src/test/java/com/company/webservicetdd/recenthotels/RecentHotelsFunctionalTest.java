package com.company.webservicetdd.recenthotels;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Locale;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.company.webservicetdd.FunctionalTestBase;
import com.company.webservicetdd.hotel.HotelId;
import com.company.webservicetdd.recenthotels.client.configuration.RecentHotelsProviderClientConfiguration;
import com.company.webservicetdd.user.User;
import com.google.common.collect.ImmutableList;

/**
 * Functional tests for the recent hotel endpoint.
 *
 * @author Daniel_Imre
 */
@ContextConfiguration(classes = RecentHotelsProviderClientConfiguration.class)
public class RecentHotelsFunctionalTest extends FunctionalTestBase {
    @Inject
    private RecentHotelsProvider client;

    @Test
    public void shouldReturnTwoLocalizedRecentHotelsForUser() {
        RecentHotels result = client.getRecentHotels(RecentHotelsParameter.builder().forUser(User.of(1L)).withLocale(Locale.UK).limit(2).build());

        assertThat(result, is(new RecentHotels(ImmutableList.of(new RecentHotel(HotelId.of(1L), "hotel1"), new RecentHotel(HotelId.of(2L), "hotel2")))));
    }

    @Test
    public void shouldReturnOneLocalizedRecentHotelsForUser2() {
        RecentHotels result = client.getRecentHotels(RecentHotelsParameter.builder().forUser(User.of(2L)).withLocale(Locale.GERMANY).limit(1).build());

        assertThat(result, is(new RecentHotels(ImmutableList.of(new RecentHotel(HotelId.of(4L), "hotel4-de")))));
    }
}
