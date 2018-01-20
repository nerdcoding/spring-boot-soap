/*
 * SoapWebServiceConfiguration.java
 *
 * Copyright (c) 2018, Tobias Koltsch. All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 and
 * only version 2 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/gpl-2.0.html>.
 */

package org.nerdcoding.example.soap.server;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configures the usage of Apache CXF as JAX-WS implementation in Spring Boot.
 */
@Configuration
public class SoapWebServiceConfiguration {

    public static final String BASE_URL = "/api/soap";

    /**
     * The {@link SpringBus} gets the Apache CXF framework up and running, with all needed CXF modules.
     *
     * @return The created {@link SpringBus}.
     */
    @Bean(name= Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    /**
     * The {@link CXFServlet} is the Apache CXF way to handle incoming SOAP calls. Here we integrate that Servlet into
     * Spring Boot to handle all requests to the {@link SoapWebServiceConfiguration#BASE_URL}.
     *
     * @return The registered servlet.
     */
    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        // The "CXFServlet" handles all SOAP calls to the URI '/soap-api/*'.
        return new ServletRegistrationBean<>(new CXFServlet(), BASE_URL + "/*");
    }

}
