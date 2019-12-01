package com.epam.jwd.tetrahedron.service.impl;

import com.epam.jwd.tetrahedron.bean.Point3D;
import com.epam.jwd.tetrahedron.service.Point3DService;
import com.epam.jwd.tetrahedron.util.ParserFigure;
import com.epam.jwd.tetrahedron.util.exception.FileException;

public class Point3DServiceImpl implements Point3DService {
    private ParserFigure parser;

    public Point3DServiceImpl() {
        parser = new ParserFigure();
    }

    public double distanceBetweenTwoPoints(Point3D point1, Point3D point2) {
        return Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2) +
                Math.pow(point1.getZ() - point2.getZ(), 2));
    }

    public Point3D createPoint(int pointNumber) throws FileException {
        Point3D point = parser.toPoint3D(pointNumber);
        return point;
    }
}
