package com.company.webservicetdd.recenthotels.web;

import static java.util.Objects.requireNonNull;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.webservicetdd.recenthotels.RecentHotels;
import com.company.webservicetdd.recenthotels.RecentHotelsParameter;
import com.company.webservicetdd.recenthotels.RecentHotelsProvider;

/**
 * Endpoint controller for {@link RecentHotelsProvider}.
 *
 * @author Daniel_Imre
 */
@Controller
public class RecentHotelsProviderController implements RecentHotelsProvider {
    private final RecentHotelsProvider service;

    public RecentHotelsProviderController(RecentHotelsProvider service) {
        this.service = requireNonNull(service);
    }

    @Override
    @ResponseBody
    @RequestMapping(path = "/recenthotels", method = RequestMethod.POST)
    public RecentHotels getRecentHotels(@RequestBody RecentHotelsParameter parameters) {
        return service.getRecentHotels(parameters);
    }
}
