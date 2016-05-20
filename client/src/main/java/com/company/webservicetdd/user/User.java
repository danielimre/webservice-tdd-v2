package com.company.webservicetdd.user;

import java.util.Objects;

import com.google.common.base.MoreObjects;

/**
 * A user.
 *
 * @author Daniel_Imre
 */
public final class User {
    private final long id;

    private User(long id) {
        this.id = id;
    }

    public static User of(long id) {
        return new User(id);
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
        User user = (User) o;
        return Objects.equals(id, user.id);
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
