/*
 * ClientRestController.java
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

package org.nerdcoding.example.soap.soap.client.web;

import org.nerdcoding.example.soap.server.web.Weather;
import org.nerdcoding.example.soap.server.web.WeatherEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller provides a REST endpoint used to call the `sopa-client`.
 */
@RestController
@RequestMapping("/client/api/rest")
public class ClientRestController {

    private final WeatherEndpoint weatherEndpoint;

    @Autowired
    public ClientRestController(final WeatherEndpoint weatherEndpoint) {
        this.weatherEndpoint = weatherEndpoint;
    }

    @GetMapping("/weather/{city}")
    public Weather callSoapWebService(@PathVariable("city") final String city) {
        return weatherEndpoint.getWeather(city);
    }

}
