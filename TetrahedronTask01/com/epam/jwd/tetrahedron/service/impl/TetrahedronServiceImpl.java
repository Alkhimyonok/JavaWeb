package com.epam.jwd.tetrahedron.service.impl;

import com.epam.jwd.tetrahedron.bean.Point3D;
import com.epam.jwd.tetrahedron.bean.Tetrahedron;
import com.epam.jwd.tetrahedron.dao.TetrahedronDAO;
import com.epam.jwd.tetrahedron.dao.exception.DAOException;
import com.epam.jwd.tetrahedron.dao.factory.DAOFactory;
import com.epam.jwd.tetrahedron.service.Point3DService;
import com.epam.jwd.tetrahedron.service.TetrahedronService;
import com.epam.jwd.tetrahedron.service.exception.ServiceException;
import com.epam.jwd.tetrahedron.service.factory.ServiceFactory;

public class TetrahedronServiceImpl implements TetrahedronService {
    private static final String POINT_SOURCE = "data\\dataBase.txt";
    private Point3DService point3DService = ServiceFactory.getInstance().getPoint3DService();
    private TetrahedronDAO tetrahedronDAO = DAOFactory.getInstance().getTetrahedronDAO();

    public void createTetrahedron() throws ServiceException {
        Tetrahedron tetrahedron = new Tetrahedron();
        Point3D[] points = new Point3D[4];
        for (int i = 0; i < 4; i++) {
            try {
                Point3D point3D = point3DService.createPoint(POINT_SOURCE, i);
                points[i] = point3D;
            } catch (DAOException e) {
                throw new ServiceException(e);
            }
        }
        tetrahedron.setPoints(points);
        calculateSide(tetrahedron);
        calculateSquare(tetrahedron);
        calculateVolume(tetrahedron);
        try {
            tetrahedronDAO.createTetrahedron(tetrahedron);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void calculateSide(Tetrahedron tetrahedron) {
        Point3D point1 = tetrahedron.getPoints()[0];
        Point3D point2 = tetrahedron.getPoints()[1];
        tetrahedron.setSide(point3DService.distanceBetweenTwoPoints(point1, point2));
    }

    public void calculateVolume(Tetrahedron tetrahedron) {
        double volume = Math.pow(tetrahedron.getSide(), 3) * Math.sqrt(2) / 12;
        tetrahedron.setVolume(volume);
    }

    public void calculateSquare(Tetrahedron tetrahedron) {
        double square = Math.sqrt(3) * Math.pow(tetrahedron.getSide(), 2);
        tetrahedron.setSquare(square);
    }

    public double ratioByCoordinatePlane(Tetrahedron tetrahedron, String coordinatePlane) {
        double koef = 0;
        int V1;
        int V2;
        switch (coordinatePlane) {
            case "OX":
                int x1 = tetrahedron.getPoints()[0].getX();
                int x2 = 0;
                if (x1 > 0) {
                    for (Point3D points : tetrahedron.getPoints())
                        if (points.getX() < 0) {
                            x2 = points.getX();
                        }
                } else {
                    for (Point3D points : tetrahedron.getPoints())
                        if (points.getX() < 0) {
                            x2 = points.getX();
                        }
                }
                V1 = Math.abs(x1);
                V2 = Math.abs(x2);
                koef = V1 / V2;
                break;
            case "OY":
                int y1 = tetrahedron.getPoints()[0].getY();
                int y2 = 0;
                if (y1 > 0) {
                    for (Point3D points : tetrahedron.getPoints())
                        if (points.getY() < 0) {
                            y2 = points.getY();
                        }
                } else {
                    for (Point3D points : tetrahedron.getPoints())
                        if (points.getY() < 0) {
                            y2 = points.getY();
                        }
                }
                V1 = Math.abs(y1);
                V2 = Math.abs(y2);
                koef = V1 / V2;
                break;
            case "OZ":
                int z1 = tetrahedron.getPoints()[0].getZ();
                int z2 = 0;
                if (z1 > 0) {
                    for (Point3D points : tetrahedron.getPoints())
                        if (points.getZ() < 0) {
                            z2 = points.getZ();
                        }
                } else {
                    for (Point3D points : tetrahedron.getPoints())
                        if (points.getZ() < 0) {
                            z2 = points.getZ();
                        }
                }
                V1 = Math.abs(z1);
                V2 = Math.abs(z2);
                koef = V1 / V2;
                break;
        }
        return Math.pow(koef, 3);
    }
}
