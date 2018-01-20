/*
 * LocalDateAdapter.java
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

package org.nerdcoding.example.soap.server.web.model.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Handles marshal/unmarshal of {@link LocalDate} to and from XML.
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(final String v) throws Exception {
        return LocalDate.parse(v, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
