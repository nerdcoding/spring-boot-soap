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
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.nerdcoding.example.soap.server.web.WeatherEndpoint;
import org.nerdcoding.example.soap.server.web.WeatherEndpointImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * Configures the usage of Apache CXF as JAX-WS implementation in Spring Boot.
 */
@Configuration
public class SoapWebServiceConfiguration {

    public static final String BASE_URL = "/server/api/soap";
    private static final String WEB_SERVICE_WSDL_SUFFIX = "Service.wsdl";

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
        return new ServletRegistrationBean<>(new CXFServlet(), BASE_URL + "/*");
    }

    /**
     * Register the SOAP web service implementation as Spring bean.
     *
     * @return The {@link WeatherEndpointImpl} instance.
     */
    @Bean
    public WeatherEndpoint weatherEndpoint() {
        return new WeatherEndpointImpl();
    }

    /**
     * Publish the SOAP web services.
     *
     * @param springBus The Apache CXF {@link SpringBus}.
     * @param weatherEndpoint The SOAP web service to publish.
     * @return The created web service {@link Endpoint}.
     */
    @Bean
    public Endpoint endpoint(
            @Qualifier(Bus.DEFAULT_BUS_ID) final SpringBus springBus,
            final WeatherEndpoint weatherEndpoint) {
        final EndpointImpl endpoint = new EndpointImpl(springBus, weatherEndpoint);
        endpoint.publish("/" + WeatherEndpoint.class.getSimpleName());
        endpoint.setWsdlLocation(WeatherEndpoint.class.getSimpleName() + WEB_SERVICE_WSDL_SUFFIX);
        return endpoint;
    }

}
