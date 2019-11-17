package com.epam.jwd.tetrahedron.dao.impl;

import com.epam.jwd.tetrahedron.bean.Point3D;
import com.epam.jwd.tetrahedron.bean.Tetrahedron;
import com.epam.jwd.tetrahedron.dao.TetrahedronDAO;
import com.epam.jwd.tetrahedron.dao.exception.DAOException;

import java.io.*;

public class TXXTTetrahedronDAOImpl implements TetrahedronDAO {
    private static final String TETRAHEDRON_SOURCE = "data\\tetrahedronBase.txt";

    public void createTetrahedron(Tetrahedron tetrahedron) throws DAOException {
        String tetrahedronInfo = "";
        for (Point3D buff : tetrahedron.getPoints()) {
            tetrahedronInfo += Integer.toString(buff.getX()) + " " + Integer.toString(buff.getY()) + " " + Integer.toString(buff.getZ()) + "\n";
        }
        tetrahedronInfo+=Double.toString(tetrahedron.getSide())+" "+Double.toString(tetrahedron.getSquare())+" "+Double.toString(tetrahedron.getVolume());
        try (FileWriter fileReader = new FileWriter(new File(TETRAHEDRON_SOURCE), true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileReader)) {
            bufferedWriter.write(tetrahedronInfo);
        } catch (FileNotFoundException e) {
            throw new DAOException(e);

        } catch (IOException e) {
            throw new DAOException(e);
        }
    }
}
