package com.company.webservicetdd.recenthotels.service.configuration;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.company.webservicetdd.hotels.dao.HotelNameDao;
import com.company.webservicetdd.hotels.dao.StubHotelNameDao;
import com.company.webservicetdd.recenthotels.dao.RecentHotelsDao;
import com.company.webservicetdd.recenthotels.dao.StubRecentHotelsDao;
import com.company.webservicetdd.recenthotels.service.RecentHotelsService;

/**
 * Service configuration for {@link com.company.webservicetdd.recenthotels.RecentHotelsProvider}.
 *
 * @author Daniel_Imre
 */
@Configuration
public class RecentHotelsProviderServiceConfiguration {
    @Bean
    public RecentHotelsService recentHotelsProviderService(RecentHotelsDao recentHotelsDao, HotelNameDao hotelNameDao) {
        return new RecentHotelsService(recentHotelsDao, hotelNameDao);
    }

    @Profile("default")
    @Configuration
    static class DaoConfiguration {
        @Bean
        public RecentHotelsDao recentHotelsDao() {
            return user -> null;
        }

        @Bean
        public HotelNameDao hotelNameDao() {
            return (hotelId, locale) -> Optional.empty();
        }
    }

    @Profile("stub")
    @Configuration
    static class StubDaoConfiguration {
        @Bean
        public RecentHotelsDao recentHotelsDao() {
            return new StubRecentHotelsDao();
        }

        @Bean
        public HotelNameDao hotelNameDao() {
            return new StubHotelNameDao();
        }
    }
}
