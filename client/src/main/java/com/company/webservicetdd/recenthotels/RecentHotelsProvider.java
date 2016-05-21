package com.company.webservicetdd.recenthotels;

/**
 * Provides recent hotels.
 *
 * @author Daniel_Imre
 */
public interface RecentHotelsProvider {

    /**
     * Returns recent hotels for the given parameters.
     *
     * @param parameters the parameter to filter recent hotels with
     * @return the matching recent hotels, never null
     */
    RecentHotels getRecentHotels(RecentHotelsParameter parameters);
}
