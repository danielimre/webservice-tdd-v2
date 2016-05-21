package com.company.webservicetdd.recenthotels.client;

/**
 * Represents some kind of error during recent hotels service execution.
 *
 * @author Daniel_Imre
 */
public class RecentHotelsClientError extends RuntimeException {

    public RecentHotelsClientError(String message, Throwable cause) {
        super(message, cause);
    }
}
