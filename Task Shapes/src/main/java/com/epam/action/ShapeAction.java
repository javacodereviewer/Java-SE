package com.epam.action;

import com.epam.entity.Shape;

public interface ShapeAction<T extends Shape> {

    double getArea(T shape);

    double getPerimeter(T shape);
}
