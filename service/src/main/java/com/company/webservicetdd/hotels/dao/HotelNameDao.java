package com.company.webservicetdd.hotels.dao;

import java.util.Locale;
import java.util.Optional;

import com.company.webservicetdd.hotel.HotelId;

/**
 * DAO to retrieve localized name of hotels.
 *
 * @author Daniel_Imre
 */
public interface HotelNameDao {
    /**
     * Gets the localized name of a hotel.
     *
     * @param hotelId the id of the hotel
     * @param locale  the locale to get name for
     * @return the localized name, can be absent
     */
    Optional<String> getNameFor(HotelId hotelId, Locale locale);
}
