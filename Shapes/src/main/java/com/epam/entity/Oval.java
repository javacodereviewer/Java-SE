package com.epam.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;
import java.util.Objects;

public class Oval extends Shape {

    private List<Point> vertices;

    public Oval(List<Point> vertices) {
        this.vertices = vertices;
    }

    public List<Point> getVertices() {
        return vertices;
    }

    public void setVertices(List<Point> vertices) {
        this.vertices = vertices;
    }

    @Override
    public String toString() {
        return vertices.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oval oval = (Oval) o;
        return Objects.equals(vertices, oval.vertices);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash
                + (this.vertices != null ? this.vertices.hashCode() : 0);
        return hash;
    }
}
