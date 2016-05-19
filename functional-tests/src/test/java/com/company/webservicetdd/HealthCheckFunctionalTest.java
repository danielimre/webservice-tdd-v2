package com.company.webservicetdd;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.containsString;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

/**
 * Checks if the app is running, index.html is accessible and functional tests are set up correctly.
 *
 * @author Daniel_Imre
 */
public class HealthCheckFunctionalTest extends FunctionalTestBase {
    @Value("${WEBSERVICETDD_BASE_URL}")
    private String baseUrl;

    @Test
    public void shouldReturnHello() {
        get(baseUrl).then().assertThat().body(containsString("Hello!"));
    }
}
