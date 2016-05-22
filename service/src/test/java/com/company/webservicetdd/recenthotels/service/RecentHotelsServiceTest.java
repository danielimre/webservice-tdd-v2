package com.company.webservicetdd.recenthotels.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.company.webservicetdd.hotel.HotelId;
import com.company.webservicetdd.hotels.dao.HotelNameDao;
import com.company.webservicetdd.recenthotels.RecentHotel;
import com.company.webservicetdd.recenthotels.RecentHotels;
import com.company.webservicetdd.recenthotels.RecentHotelsParameter;
import com.company.webservicetdd.recenthotels.dao.RecentHotelsDao;
import com.company.webservicetdd.user.User;
import com.google.common.collect.ImmutableList;

/**
 * Unit test for {@link RecentHotelsService}.
 *
 * @author Daniel_Imre
 */
public class RecentHotelsServiceTest {
    private static final User USER = User.of(1L);
    private static final HotelId HOTEL_ID = HotelId.of(1L);
    private static final Locale LOCALE = Locale.ENGLISH;
    private static final String HOTEL_NAME = "name1";
    private static final HotelId HOTEL_ID2 = HotelId.of(2L);
    private RecentHotelsService service;
    @Mock
    private RecentHotelsDao recentHotelDao;
    @Mock
    private HotelNameDao hotelNameDao;

    @Before
    public void initContext() {
        initMocks(this);
        service = new RecentHotelsService(recentHotelDao, hotelNameDao);
    }

    @Test
    public void shouldFetchRecentHotelsForUserAndPopulateForLocale() {
        when(recentHotelDao.getRecentHotelsFor(USER)).thenReturn(Arrays.asList(HOTEL_ID));
        when(hotelNameDao.getNameFor(HOTEL_ID, LOCALE)).thenReturn(Optional.of(HOTEL_NAME));

        RecentHotels result = service.getRecentHotels(recentHotelsParameters());

        assertThat(result, is(new RecentHotels(ImmutableList.of(new RecentHotel(HOTEL_ID, HOTEL_NAME)))));
    }

    @Test
    public void shouldReturnOnlyLimitedHotels() {
        when(recentHotelDao.getRecentHotelsFor(USER)).thenReturn(Arrays.asList(HOTEL_ID, HOTEL_ID2, HotelId.of(3L)));
        when(hotelNameDao.getNameFor(isA(HotelId.class), eq(LOCALE))).thenReturn(Optional.of(HOTEL_NAME));

        RecentHotels result = service.getRecentHotels(recentHotelsParameters());

        assertThat(result, is(new RecentHotels(ImmutableList.of(new RecentHotel(HOTEL_ID, HOTEL_NAME), new RecentHotel(HOTEL_ID2, HOTEL_NAME)))));
    }

    @Test
    public void shouldOmitHotelsWithoutName() {
        when(recentHotelDao.getRecentHotelsFor(USER)).thenReturn(Arrays.asList(HOTEL_ID, HOTEL_ID2));
        when(hotelNameDao.getNameFor(HOTEL_ID, LOCALE)).thenReturn(Optional.of(HOTEL_NAME));
        when(hotelNameDao.getNameFor(HOTEL_ID2, LOCALE)).thenReturn(Optional.empty());

        RecentHotels result = service.getRecentHotels(recentHotelsParameters());

        assertThat(result, is(new RecentHotels(ImmutableList.of(new RecentHotel(HOTEL_ID, HOTEL_NAME)))));
    }

    private RecentHotelsParameter recentHotelsParameters() {
        return RecentHotelsParameter.builder().forUser(USER).withLocale(LOCALE).limit(2).build();
    }
}
