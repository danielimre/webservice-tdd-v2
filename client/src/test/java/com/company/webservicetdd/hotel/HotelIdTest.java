package com.company.webservicetdd.hotel;

import org.junit.Test;

import com.google.common.testing.EqualsTester;

/**
 * Unit test for {@link HotelId}.
 *
 * @author Daniel_Imre
 */
public class HotelIdTest {
    @Test
    public void shouldImplementEqualsWell() {
        HotelId idA = HotelId.of(1L);
        new EqualsTester()
                .addEqualityGroup(idA, idA, HotelId.of(1L))
                .addEqualityGroup(HotelId.of(2L))
                .testEquals();
    }
}
