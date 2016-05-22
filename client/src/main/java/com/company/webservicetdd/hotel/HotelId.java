package com.company.webservicetdd.hotel;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

/**
 * A hotel id.
 *
 * @author Daniel_Imre
 */
public final class HotelId {
    private final long id;

    @JsonCreator
    private HotelId(@JsonProperty("id") long id) {
        this.id = id;
    }

    public static HotelId of(long id) {
        return new HotelId(id);
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HotelId hotelId = (HotelId) o;
        return Objects.equals(id, hotelId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }
}
