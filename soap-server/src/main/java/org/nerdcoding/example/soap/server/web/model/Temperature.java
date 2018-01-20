/*
 * Temperature.java
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

import java.util.Objects;

/**
 * Holds a temperature value with the associated scale.
 */
public class Temperature {

    private String scale;
    private Double value;

    public String getScale() {
        return scale;
    }

    public void setScale(final String scale) {
        this.scale = scale;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(final Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Temperature that = (Temperature) o;
        return Objects.equals(scale, that.scale) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scale, value);
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "scale='" + scale + '\'' +
                ", value=" + value +
                '}';
    }
}
