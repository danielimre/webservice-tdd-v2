package com.company.webservicetdd.recenthotels.dao;

import java.util.List;

import com.company.webservicetdd.hotel.HotelId;
import com.company.webservicetdd.user.User;
import com.google.common.collect.ImmutableList;

/**
 * Stub implementation of {@link RecentHotelsDao}.
 *
 * @author Daniel_Imre
 */
public class StubRecentHotelsDao implements RecentHotelsDao {
    @Override
    public List<HotelId> getRecentHotelsFor(User user) {
        List<HotelId> hotels = ImmutableList.of(HotelId.of(4L), HotelId.of(5L), HotelId.of(6L));
        if (User.of(1L).equals(user)) {
            hotels = ImmutableList.of(HotelId.of(1L), HotelId.of(2L), HotelId.of(3L));
        }
        return hotels;
    }
}
