package com.company.webservicetdd.recenthotels;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

/**
 * Bunch of recent hotels.
 *
 * @author Daniel_Imre
 */
public class RecentHotels {
    private static final RecentHotels EMPTY = new RecentHotels(ImmutableList.of());
    private final List<RecentHotel> hotels;

    @JsonCreator
    public RecentHotels(@JsonProperty("hotels") List<RecentHotel> hotels) {
        this.hotels = ImmutableList.copyOf(requireNonNull(hotels));
    }

    public List<RecentHotel> getHotels() {
        return hotels;
    }

    public static RecentHotels empty() {
        return EMPTY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecentHotels that = (RecentHotels) o;
        return Objects.equals(hotels, that.hotels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotels);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("hotels", hotels).toString();
    }
}
