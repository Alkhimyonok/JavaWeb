package com.epam.jwd.tetrahedron.service;

import com.epam.jwd.tetrahedron.bean.Point3D;
import com.epam.jwd.tetrahedron.dao.exception.DAOException;

public interface Point3DService {
    double distanceBetweenTwoPoints(Point3D point1, Point3D point2);

    Point3D createPoint(String fileName, int pointNumber) throws DAOException;
}