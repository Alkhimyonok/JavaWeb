package com.epam.jwd.tetrahedron.service.factory;

import com.epam.jwd.tetrahedron.service.Point3DService;
import com.epam.jwd.tetrahedron.service.TetrahedronService;
import com.epam.jwd.tetrahedron.service.impl.Point3DServiceImpl;
import com.epam.jwd.tetrahedron.service.impl.TetrahedronServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final Point3DService point3DService = new Point3DServiceImpl();
    private final static TetrahedronService tetrahedronService = new TetrahedronServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public Point3DService getPoint3DService() {
        return point3DService;
    }

    public static TetrahedronService getTetrahedronService() {
        return tetrahedronService;
    }
}