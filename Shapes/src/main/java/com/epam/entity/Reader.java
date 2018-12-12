package com.epam.entity;

import com.epam.validation.CoordinateValidation;

import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.net.URISyntaxException;

public class Reader {

    private static final String fileName = "coordinates.txt";

    private CoordinateValidation validation = new CoordinateValidation();

    private static final String COORDINATE_SEPARATOR = " ";

    public List<Oval> readLine() {
        List<Oval> listOfOvals = new ArrayList<>();
        try (Stream<String> streamOfLines = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))) {
            List<String> listOfLines = streamOfLines.collect(Collectors.toList());
            listOfOvals = listOfLines.stream()
                    .filter(validation::isValid)
                    .map(this::toPoints)
                    .map(Oval::new)
                    .collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return listOfOvals;
    }

    private List<Point> toPoints(String coordinates) {
        List<Point> points = new ArrayList<>();
        String[] coordinatesArray = coordinates.split(COORDINATE_SEPARATOR);
        for (int i = 0; i < coordinatesArray.length; i++) {
            Double coordinateX = Double.valueOf(coordinatesArray[i]);
            Double coordinateY = Double.valueOf(coordinatesArray[++i]);
            Point point = new Point(coordinateX, coordinateY);
            points.add(point);
        }
        return points;
    }
}
