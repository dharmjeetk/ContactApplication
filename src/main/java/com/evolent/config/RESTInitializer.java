package com.evolent.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This is Configuration class for scanning all backend packages to find
 * relevant components/repository and service
 * 
 * @author dharmjeet.kumar
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.evolent.config", "com.evolent.backend.dao", "com.evolent.backend.dao.impl" })
public class RESTInitializer {

}
