/*
 * Weather.java
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

package org.nerdcoding.example.soap.server.web.model;

import org.nerdcoding.example.soap.server.web.model.adapter.LocalDateAdapter;

import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Holds of the weather at specific location.
 */
public class Weather {

    private LocalDate day;
    private String description;
    private Location location;
    private Temperature temperature;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlSchemaType(name="dateTime")
    public LocalDate getDay() {
        return day;
    }

    public void setDay(final LocalDate day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(final Location location) {
        this.location = location;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(final Temperature temperature) {
        this.temperature = temperature;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Weather weather = (Weather) o;
        return Objects.equals(day, weather.day) &&
                Objects.equals(description, weather.description) &&
                Objects.equals(location, weather.location) &&
                Objects.equals(temperature, weather.temperature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, description, location, temperature);
    }

    @Override
    public String toString() {
        return "Weather{" +
                "day=" + day +
                ", description='" + description + '\'' +
                ", location=" + location +
                ", temperature=" + temperature +
                '}';
    }
}
