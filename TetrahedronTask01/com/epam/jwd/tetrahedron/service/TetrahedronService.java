package com.epam.jwd.tetrahedron.service;

import com.epam.jwd.tetrahedron.bean.Tetrahedron;
import com.epam.jwd.tetrahedron.service.exception.ServiceException;

public interface TetrahedronService {
    void createTetrahedron() throws ServiceException;

    void calculateSide(Tetrahedron tetrahedron);

    void calculateVolume(Tetrahedron tetrahedron);

    void calculateSquare(Tetrahedron tetrahedron);

    double ratioByCoordinatePlane(Tetrahedron tetrahedron, String coordinatePlane);
}
