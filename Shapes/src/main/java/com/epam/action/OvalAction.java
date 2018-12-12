package com.epam.action;

import com.epam.entity.Oval;
import com.epam.entity.Point;

import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class OvalAction implements ShapeAction<Oval> {

    public double getArea(Oval oval) {
        return PI
                * getSemiAxisByY(oval)
                * getSemiAxisByX(oval);
    }

    public double getPerimeter(Oval oval) {
        return 2 * PI
                * sqrt((pow(getSemiAxisByY(oval), 2)
                + pow(getSemiAxisByX(oval), 2))
                / 2);
    }

    public boolean isPointsBuildOval(Oval oval) {
        Point firstVertex = oval.getVertices().get(0);
        Point secondVertex = oval.getVertices().get(1);
        return firstVertex.getX() != secondVertex.getX()
                && firstVertex.getY() != secondVertex.getY();
    }

    public boolean isCircle(Oval oval) {
        return getSemiAxisByX(oval) == getSemiAxisByY(oval);
    }

    private double getSemiAxisByX(Oval oval) {
        Point firstVertex = oval.getVertices().get(0);
        Point secondVertex = oval.getVertices().get(1);
        return abs(firstVertex.getX() - secondVertex.getX());
    }

    private double getSemiAxisByY(Oval oval) {
        Point firstVertex = oval.getVertices().get(0);
        Point secondVertex = oval.getVertices().get(1);
        return abs(firstVertex.getY() - secondVertex.getY());
    }
}
