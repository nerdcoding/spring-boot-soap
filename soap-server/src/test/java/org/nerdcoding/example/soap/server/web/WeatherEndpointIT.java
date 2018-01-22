/*
 * WeatherEndpointIT.java
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

package org.nerdcoding.example.soap.server.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nerdcoding.example.soap.server.web.model.Weather;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Integration test for the {@link WeatherEndpointImpl}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WeatherEndpointIT {

    @LocalServerPort
    private int randomServerPort;

    private WeatherEndpoint weatherEndpoint;

    @Before
    public void setUp()  {
        final JaxWsProxyFactoryBean jaxWsProxyFactory = new JaxWsProxyFactoryBean();
        jaxWsProxyFactory.setServiceClass(WeatherEndpoint.class);
        jaxWsProxyFactory.setAddress("http://127.0.0.1:" + randomServerPort + "/server/api/soap/WeatherEndpoint");
        this.weatherEndpoint = (WeatherEndpoint) jaxWsProxyFactory.create();
    }

    @Test
    public void testGetWeatherInformation() {
        final String city = "Tegucigalpa";

        final Weather result = weatherEndpoint.getWeather(city);
        assertThat(result).isNotNull();
        assertThat(result.getLocation()).isNotNull();
        assertThat(result.getTemperature()).isNotNull();
        assertThat(result.getLocation().getCity()).isEqualTo(city);
    }

}
