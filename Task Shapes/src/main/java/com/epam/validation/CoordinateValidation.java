package com.epam.validation;

import org.apache.commons.lang3.math.NumberUtils;

public class CoordinateValidation {

    private static final String COORDINATE_SEPARATOR = " ";

    private static final int MAX_COUNT_OF_COORDINATES = 4;

    public boolean isValid(String line) {
        String[] coordinates = line.split(COORDINATE_SEPARATOR);
        for (String coordinate : coordinates) {
            if (!NumberUtils.isCreatable(coordinate)) {
                return false;
            }
        }
        return coordinates.length == MAX_COUNT_OF_COORDINATES;
    }
}
