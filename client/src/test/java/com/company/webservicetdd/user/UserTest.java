package com.company.webservicetdd.user;

import org.junit.Test;

import com.google.common.testing.EqualsTester;

/**
 * Unit test for {@link User}.
 *
 * @author Daniel_Imre
 */
public class UserTest {
    @Test
    public void shouldImplementEqualsWell() {
        User userA = User.of(1L);
        new EqualsTester()
                .addEqualityGroup(userA, userA, User.of(1L))
                .addEqualityGroup(User.of(2L))
                .testEquals();
    }
}
