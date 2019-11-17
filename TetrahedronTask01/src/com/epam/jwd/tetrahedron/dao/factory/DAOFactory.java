package com.epam.jwd.tetrahedron.dao.factory;

import com.epam.jwd.tetrahedron.dao.Point3DDAO;
import com.epam.jwd.tetrahedron.dao.TetrahedronDAO;
import com.epam.jwd.tetrahedron.dao.impl.TXTPoint3DDAOImpl;
import com.epam.jwd.tetrahedron.dao.impl.TXXTTetrahedronDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final Point3DDAO point3DDAO = new TXTPoint3DDAOImpl();
    private final TetrahedronDAO tetrahedronDAO = new TXXTTetrahedronDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public Point3DDAO getPoint3DDAO() {
        return point3DDAO;
    }

    public TetrahedronDAO getTetrahedronDAO() {
        return tetrahedronDAO;
    }
}