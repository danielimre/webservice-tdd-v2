package com.company.webservicetdd.recenthotels;

import org.junit.Test;

import com.company.webservicetdd.hotel.HotelId;
import com.google.common.testing.EqualsTester;

/**
 * Unit test for {@link RecentHotel}.
 *
 * @author Daniel_Imre
 */
public class RecentHotelTest {

    @Test
    public void shouldImplementEqualsWell() {
        HotelId hotelIdA = HotelId.of(1L);
        String hotelNameA = "a";
        HotelId hotelIdB = HotelId.of(2L);
        String hotelNameB = "b";
        RecentHotel recentHotel = new RecentHotel(hotelIdA, hotelNameA);
        new EqualsTester()
                .addEqualityGroup(recentHotel, recentHotel, new RecentHotel(hotelIdA, hotelNameA))
                .addEqualityGroup(new RecentHotel(hotelIdA, hotelNameB), new RecentHotel(hotelIdA, hotelNameB))
                .addEqualityGroup(new RecentHotel(hotelIdB, hotelNameB), new RecentHotel(hotelIdB, hotelNameB))
                .testEquals();
    }
}
