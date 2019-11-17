package com.epam.jwd.tetrahedron.service.impl;

import com.epam.jwd.tetrahedron.bean.Point3D;
import com.epam.jwd.tetrahedron.dao.Point3DDAO;
import com.epam.jwd.tetrahedron.dao.exception.DAOException;
import com.epam.jwd.tetrahedron.dao.factory.DAOFactory;
import com.epam.jwd.tetrahedron.service.Point3DService;

public class Point3DServiceImpl implements Point3DService {
    private Point3DDAO point3DDAO = DAOFactory.getInstance().getPoint3DDAO();

    public double distanceBetweenTwoPoints(Point3D point1, Point3D point2) {
        return Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2) +
                Math.pow(point1.getZ() - point2.getZ(), 2));
    }

    public Point3D createPoint(String fileName, int pointNumber) throws DAOException {
        Point3D point = point3DDAO.createPoint3D(fileName,pointNumber);
        return point;
    }
}
