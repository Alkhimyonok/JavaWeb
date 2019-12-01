package com.epam.jwd.tetrahedron.service.impl;

import com.epam.jwd.tetrahedron.bean.Point3D;
import com.epam.jwd.tetrahedron.bean.Tetrahedron;
import com.epam.jwd.tetrahedron.repository.impl.TetrahedronRepository;
import com.epam.jwd.tetrahedron.service.Point3DService;
import com.epam.jwd.tetrahedron.service.TetrahedronService;
import com.epam.jwd.tetrahedron.service.exception.ServiceException;
import com.epam.jwd.tetrahedron.util.exception.FileException;

public class TetrahedronServiceImpl implements TetrahedronService {
    private static Point3DService point3DService;

    public TetrahedronServiceImpl() {
        point3DService = new Point3DServiceImpl();
    }

    public Tetrahedron createTetrahedron() throws ServiceException {
        Tetrahedron tetrahedron = new Tetrahedron();
        Point3D point1;
        Point3D point2;
        Point3D point3;
        Point3D point4;
        try {
            point1 = point3DService.createPoint(0);
            point2 = point3DService.createPoint(1);
            point3 = point3DService.createPoint(2);
            point4 = point3DService.createPoint(3);
        } catch (FileException e) {
            throw new ServiceException(e);
        }
        tetrahedron.setPoint1(point1);
        tetrahedron.setPoint2(point2);
        tetrahedron.setPoint3(point3);
        tetrahedron.setPoint4(point4);
        return tetrahedron;
    }

    public double calculateSide(Tetrahedron tetrahedron) {
        double side;
        Point3D point1 = tetrahedron.getPoint1();
        Point3D point2 = tetrahedron.getPoint2();
        side = point3DService.distanceBetweenTwoPoints(point1, point2);
        return side;
    }

    public double calculateSquare(double side) {
        return Math.sqrt(3) * Math.pow(side, 2);
    }

    public double calculateVolume(double side) {
        return Math.pow(side, 3) * Math.sqrt(2) / 12;
    }

    public boolean isOnTheFirstQuadrante(Tetrahedron tetrahedron) {
        Point3D point1 = tetrahedron.getPoint1();
        Point3D point2 = tetrahedron.getPoint2();
        Point3D point3 = tetrahedron.getPoint3();
        Point3D point4 = tetrahedron.getPoint4();
        boolean isPoint1onTheFirstQuadrante = point1.getX() >= 0 && point1.getY() >= 0 && point1.getZ() >= 0;
        boolean isPoint2onTheFirstQuadrante = point2.getX() >= 0 && point2.getY() >= 0 && point2.getZ() >= 0;
        boolean isPoint3onTheFirstQuadrante = point3.getX() >= 0 && point3.getY() >= 0 && point3.getZ() >= 0;
        boolean isPoint4onTheFirstQuadrante = point4.getX() >= 0 && point4.getY() >= 0 && point4.getZ() >= 0;
        if (isPoint1onTheFirstQuadrante && isPoint2onTheFirstQuadrante && isPoint3onTheFirstQuadrante && isPoint4onTheFirstQuadrante) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isTetrahedron(Tetrahedron tetrahedron) {
        Point3D point1 = tetrahedron.getPoint1();
        Point3D point2 = tetrahedron.getPoint2();
        Point3D point3 = tetrahedron.getPoint3();
        Point3D point4 = tetrahedron.getPoint4();
        double side01 = point3DService.distanceBetweenTwoPoints(point1, point2);
        double side02 = point3DService.distanceBetweenTwoPoints(point1, point3);
        double side03 = point3DService.distanceBetweenTwoPoints(point1, point4);
        double side12 = point3DService.distanceBetweenTwoPoints(point2, point3);
        double side13 = point3DService.distanceBetweenTwoPoints(point2, point4);
        double side23 = point3DService.distanceBetweenTwoPoints(point3, point4);
        boolean condition = side01 == side02 && side02 == side03 && side03 == side12 && side12 == side13 && side13 == side23;
        return condition;
    }

    public void changeTetrahedronPoint1(int X, int Y, int Z, Tetrahedron tetrahedron, TetrahedronRepository repository) {
        Point3D newPoint = new Point3D(X, Y, Z);
        tetrahedron.setPoint1(newPoint);
        repository.updateTetrahedron(tetrahedron);
    }

    public void changeTetrahedronPoint2(int X, int Y, int Z, Tetrahedron tetrahedron, TetrahedronRepository repository) {
        Point3D newPoint = new Point3D(X, Y, Z);
        tetrahedron.setPoint2(newPoint);
        repository.updateTetrahedron(tetrahedron);
    }

    public void changeTetrahedronPoint3(int X, int Y, int Z, Tetrahedron tetrahedron, TetrahedronRepository repository) {
        Point3D newPoint = new Point3D(X, Y, Z);
        tetrahedron.setPoint3(newPoint);
        repository.updateTetrahedron(tetrahedron);
    }

    public void changeTetrahedronPoint4(int X, int Y, int Z, Tetrahedron tetrahedron, TetrahedronRepository repository) {
        Point3D newPoint = new Point3D(X, Y, Z);
        tetrahedron.setPoint4(newPoint);
        repository.updateTetrahedron(tetrahedron);
    }

    public boolean onCoordinatePlane(Tetrahedron tetrahedron) {
        int koeffX = 0;
        if (tetrahedron.getPoint1().getX() == 0) {
            koeffX++;
        }
        if (tetrahedron.getPoint2().getX() == 0) {
            koeffX++;
        }
        if (tetrahedron.getPoint3().getX() == 0) {
            koeffX++;
        }
        if (tetrahedron.getPoint4().getX() == 0) {
            koeffX++;
        }
        int koeffY = 0;
        if (tetrahedron.getPoint1().getY() == 0) {
            koeffY++;
        }
        if (tetrahedron.getPoint2().getY() == 0) {
            koeffY++;
        }
        if (tetrahedron.getPoint3().getY() == 0) {
            koeffY++;
        }
        if (tetrahedron.getPoint4().getY() == 0) {
            koeffY++;
        }
        int koeffZ = 0;
        if (tetrahedron.getPoint1().getZ() == 0) {
            koeffZ++;
        }
        if (tetrahedron.getPoint2().getZ() == 0) {
            koeffZ++;
        }
        if (tetrahedron.getPoint3().getZ() == 0) {
            koeffZ++;
        }
        if (tetrahedron.getPoint4().getZ() == 0) {
            koeffZ++;
        }
        boolean condition = (koeffX == 3 && koeffY == 3 && koeffZ == 3);
        return condition;
    }
}
