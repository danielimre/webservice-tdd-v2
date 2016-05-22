package com.company.webservicetdd.recenthotels.dao;

import java.util.List;

import com.company.webservicetdd.hotel.HotelId;
import com.company.webservicetdd.user.User;

/**
 * DAO for recent hotels.
 *
 * @author Daniel_Imre
 */
public interface RecentHotelsDao {
    /**
     * Retrieves recent hotels for a specific user.
     *
     * @param user the user to get recent hotels for
     * @return id list of recent hotels, never null
     */
    List<HotelId> getRecentHotelsFor(User user);
}
