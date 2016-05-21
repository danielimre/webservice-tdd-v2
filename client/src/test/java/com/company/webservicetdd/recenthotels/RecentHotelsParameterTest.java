package com.company.webservicetdd.recenthotels;

import java.util.Locale;

import org.junit.Test;

import com.company.webservicetdd.user.User;
import com.google.common.testing.EqualsTester;

/**
 * Unit test for {@link RecentHotelsParameter}.
 *
 * @author Daniel_Imre
 */
public class RecentHotelsParameterTest {

    @Test
    public void shouldImplementEqualsCorrectly() {
        User userA = User.of(1L);
        User userB = User.of(2L);
        Locale localeA = Locale.ENGLISH;
        Locale localeB = Locale.US;
        RecentHotelsParameter.Builder builder = RecentHotelsParameter.builder().forUser(userA).withLocale(localeA);
        RecentHotelsParameter defaultParams = builder.build();
        new EqualsTester()
                .addEqualityGroup(defaultParams, defaultParams, builder.build())
                .addEqualityGroup(builder.limit(3).build(), builder.build())
                .addEqualityGroup(builder.forUser(userB).build(), builder.build())
                .addEqualityGroup(builder.withLocale(localeB).build(), builder.build())
                .testEquals();

    }
}
