package com.company.webservicetdd;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.common.test.MockitoSpringSupport;
import com.company.webservicetdd.common.configuration.WebServiceClientExternalDependencies;

/**
 * Base class for functional tests.
 *
 * @author Daniel_Imre
 */
@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebServiceClientExternalDependencies.class})
public class FunctionalTestBase {
    @Inject
    private ApplicationContext applicationContext;

    @Before
    public void initContext() {
        MockitoSpringSupport.resetMockBeans(applicationContext);
    }
}
