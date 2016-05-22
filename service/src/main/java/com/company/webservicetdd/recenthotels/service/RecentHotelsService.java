package com.company.webservicetdd.recenthotels.service;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import com.company.webservicetdd.hotel.HotelId;
import com.company.webservicetdd.hotels.dao.HotelNameDao;
import com.company.webservicetdd.recenthotels.RecentHotel;
import com.company.webservicetdd.recenthotels.RecentHotels;
import com.company.webservicetdd.recenthotels.RecentHotelsParameter;
import com.company.webservicetdd.recenthotels.RecentHotelsProvider;
import com.company.webservicetdd.recenthotels.dao.RecentHotelsDao;

/**
 * Default implementation of {@link RecentHotelsProvider}.
 *
 * @author Daniel_Imre
 */
public class RecentHotelsService implements RecentHotelsProvider {
    private final RecentHotelsDao recentHotelDao;
    private final HotelNameDao hotelNameDao;

    public RecentHotelsService(RecentHotelsDao recentHotelDao, HotelNameDao hotelNameDao) {
        this.recentHotelDao = requireNonNull(recentHotelDao);
        this.hotelNameDao = requireNonNull(hotelNameDao);
    }

    @Override
    public RecentHotels getRecentHotels(RecentHotelsParameter parameters) {
        return Optional.ofNullable(parameters)
                .map(p -> recentHotelDao.getRecentHotelsFor(parameters.getUser()))
                .map(hotelIds -> hotelIds.stream()
                        .map(toLocalizedRecentHotel(parameters.getLocale()))
                        .filter(Objects::nonNull)
                        .limit(parameters.getLimit())
                        .collect(toList()))
                .map(RecentHotels::new)
                .orElse(RecentHotels.empty());
    }

    private Function<HotelId, RecentHotel> toLocalizedRecentHotel(Locale locale) {
        return hotelId -> hotelNameDao.getNameFor(hotelId, locale).map(name -> new RecentHotel(hotelId, name)).orElse(null);
    }
}
