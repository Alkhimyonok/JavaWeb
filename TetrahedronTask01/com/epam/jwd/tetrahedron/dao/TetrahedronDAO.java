package com.epam.jwd.tetrahedron.dao;

import com.epam.jwd.tetrahedron.bean.Tetrahedron;
import com.epam.jwd.tetrahedron.dao.exception.DAOException;

public interface TetrahedronDAO {
    void createTetrahedron(Tetrahedron tetrahedron) throws DAOException;
}
