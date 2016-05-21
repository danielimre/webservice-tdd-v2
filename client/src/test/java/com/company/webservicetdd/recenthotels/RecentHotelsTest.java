package com.company.webservicetdd.recenthotels;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.sameInstance;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.company.webservicetdd.hotel.HotelId;
import com.google.common.collect.ImmutableList;
import com.google.common.testing.EqualsTester;

/**
 * Unit test for {@link RecentHotels}.
 *
 * @author Daniel_Imre
 */
public class RecentHotelsTest {
    @Test
    public void shouldImplementEqualsWell() {
        RecentHotel recentHotelA = new RecentHotel(HotelId.of(1L), "a");
        RecentHotel recentHotelB = new RecentHotel(HotelId.of(2L), "a");
        RecentHotels emptyRecentHotels = new RecentHotels(ImmutableList.of());
        new EqualsTester()
                .addEqualityGroup(emptyRecentHotels, emptyRecentHotels, new RecentHotels(ImmutableList.of()))
                .addEqualityGroup(new RecentHotels(ImmutableList.of(recentHotelA)), new RecentHotels(ImmutableList.of(recentHotelA)))
                .addEqualityGroup(new RecentHotels(ImmutableList.of(recentHotelB)), new RecentHotels(ImmutableList.of(recentHotelB)))
                .testEquals();
    }

    @Test
    public void shouldCopyHotelList() {
        List<RecentHotel> hotels = Arrays.asList(new RecentHotel(HotelId.of(1L), "a"));
        RecentHotels recentHotels = new RecentHotels(hotels);
        assertThat(recentHotels.getHotels(), is(not(sameInstance(hotels))));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldReturnImmutableHotels() {
        new RecentHotels(Arrays.asList(new RecentHotel(HotelId.of(1L), "a"))).getHotels().clear();
    }
}
