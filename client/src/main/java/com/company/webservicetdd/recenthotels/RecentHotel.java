package com.company.webservicetdd.recenthotels;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

import com.company.webservicetdd.hotel.HotelId;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

/**
 * A localized recent hotel.
 *
 * @author Daniel_Imre
 */
public class RecentHotel {
    private final HotelId id;
    private final String name;

    @JsonCreator
    public RecentHotel(@JsonProperty("id") HotelId id, @JsonProperty("name") String name) {
        this.id = requireNonNull(id);
        this.name = requireNonNull(name);
    }

    public HotelId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecentHotel that = (RecentHotel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).add("name", name).toString();
    }
}
