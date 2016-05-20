package com.company.webservicetdd.recenthotels;

import com.google.common.collect.ImmutableList;

/**
 * Provides recent hotels.
 *
 * @author Daniel_Imre
 */
public class RecentHotelsProvider {

    /**
     * Returns recent hotels for the given parameters.
     *
     * @param parameters the parameter to filter recent hotels with
     * @return the matching recent hotels, never null
     */
    public RecentHotels getRecentHotels(RecentHotelsParameter parameters) {
        return new RecentHotels(ImmutableList.of());
    }
}
