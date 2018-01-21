/*
 * InfoService.java
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

import org.nerdcoding.example.soap.server.web.model.Location;
import org.nerdcoding.example.soap.server.web.model.Temperature;
import org.nerdcoding.example.soap.server.web.model.Weather;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.time.LocalDate;

/**
 * SOAP based web service to deliver weather information.
 */
@WebService
public class WeatherEndpoint {

    @WebMethod
    public Weather getWeather(final String city) {
        final Temperature temperature = new Temperature();
        temperature.setValue(27.8);
        temperature.setScale("°C");

        final Location location = new Location();
        location.setCity(city);
        location.setState("Hamburg");
        location.setCountry("Germany");

        final Weather weather = new Weather();
        weather.setDay(LocalDate.of(2017, 4, 23));
        weather.setDescription("Sunny");
        weather.setTemperature(temperature);
        weather.setLocation(location);

        return weather;
    }

}
