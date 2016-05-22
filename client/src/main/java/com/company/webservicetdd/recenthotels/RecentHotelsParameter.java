package com.company.webservicetdd.recenthotels;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

import java.util.Locale;
import java.util.Objects;

import com.company.webservicetdd.user.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

/**
 * Parameters for recent hotels retrieval.
 *
 * @author Daniel_Imre
 */
public final class RecentHotelsParameter {
    private final User user;
    private final Locale locale;
    private final int limit;

    private RecentHotelsParameter(Builder builder) {
        this(builder.user, builder.locale, builder.limit);
    }

    @JsonCreator
    private RecentHotelsParameter(@JsonProperty("user") User user, @JsonProperty("locale") Locale locale, @JsonProperty("limit") int limit) {
        checkArgument(limit > 0, "limit must be positive");
        this.limit = limit;
        this.user = requireNonNull(user);
        this.locale = requireNonNull(locale);
    }

    public int getLimit() {
        return limit;
    }

    public Locale getLocale() {
        return locale;
    }

    public User getUser() {
        return user;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecentHotelsParameter that = (RecentHotelsParameter) o;
        return Objects.equals(limit, that.limit) && Objects.equals(user, that.user) && Objects.equals(locale, that.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, locale, limit);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("limit", limit).add("user", user).add("locale", locale).toString();
    }

    /**
     * Builder for {@link RecentHotelsParameter}.
     */
    public static final class Builder {
        private int limit = 1;
        private User user;
        private Locale locale;

        private Builder() {
        }

        public Builder limit(int val) {
            checkArgument(val > 0, "The limit must be a positive integer.");
            limit = val;
            return this;
        }

        public Builder forUser(User val) {
            user = requireNonNull(val);
            return this;
        }

        public Builder withLocale(Locale val) {
            locale = requireNonNull(val);
            return this;
        }

        public RecentHotelsParameter build() {
            return new RecentHotelsParameter(this);
        }
    }
}
