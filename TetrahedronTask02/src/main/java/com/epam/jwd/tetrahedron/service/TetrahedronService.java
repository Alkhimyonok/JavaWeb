package com.epam.jwd.tetrahedron.service;

import com.epam.jwd.tetrahedron.bean.Tetrahedron;
import com.epam.jwd.tetrahedron.repository.impl.TetrahedronRepository;
import com.epam.jwd.tetrahedron.service.exception.ServiceException;

public interface TetrahedronService {
    Tetrahedron createTetrahedron() throws ServiceException;

    double calculateSide(Tetrahedron tetrahedron);

    double calculateSquare(double side);

    double calculateVolume(double side);

    boolean isTetrahedron(Tetrahedron tetrahedron);

    boolean onCoordinatePlane(Tetrahedron tetrahedron);

    boolean isOnTheFirstQuadrante(Tetrahedron tetrahedron);

    void changeTetrahedronPoint1(int X, int Y, int Z, Tetrahedron tetrahedron, TetrahedronRepository repository);
    void changeTetrahedronPoint2(int X, int Y, int Z, Tetrahedron tetrahedron, TetrahedronRepository repository);
    void changeTetrahedronPoint3(int X, int Y, int Z, Tetrahedron tetrahedron, TetrahedronRepository repository);
    void changeTetrahedronPoint4(int X, int Y, int Z, Tetrahedron tetrahedron, TetrahedronRepository repository);

}
