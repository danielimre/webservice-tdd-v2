package com.company.webservicetdd.hotels.dao;

import java.util.Locale;
import java.util.Optional;

import com.company.webservicetdd.hotel.HotelId;

/**
 * Stub implementation of {@link HotelNameDao}.
 *
 * @author Daniel_Imre
 */
public class StubHotelNameDao implements HotelNameDao {
    @Override
    public Optional<String> getNameFor(HotelId hotelId, Locale locale) {
        String name = "hotel" + hotelId.getId();
        if (Locale.GERMANY.equals(locale)) {
            name = name + "-de";
        }
        return Optional.of(name);
    }
}
