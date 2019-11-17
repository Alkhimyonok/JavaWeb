package com.epam.jwd.tetrahedron.dao;

import com.epam.jwd.tetrahedron.bean.Point3D;
import com.epam.jwd.tetrahedron.dao.exception.DAOException;

public interface Point3DDAO {
    Point3D createPoint3D(String fileName, int pointNumber) throws DAOException;

    //  double distanceBetweenTwoPoints(Point3D point1, Point3D point2);
}
