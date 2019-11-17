package com.epam.jwd.tetrahedron.dao.impl;


import com.epam.jwd.tetrahedron.bean.Point3D;
import com.epam.jwd.tetrahedron.dao.Point3DDAO;
import com.epam.jwd.tetrahedron.dao.exception.DAOException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TXTPoint3DDAOImpl implements Point3DDAO {
    private static int skip = 0;

    public Point3D createPoint3D(String fileName, int pointNumber) throws DAOException {
        Point3D point3D;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.skip(6 * (pointNumber)+skip);
            String[] pointInfo = reader.readLine().split("\\s");
            int x, y, z;
            x = Integer.parseInt(pointInfo[0]);
            y = Integer.parseInt(pointInfo[1]);
            z = Integer.parseInt(pointInfo[2]);
            if (x < 0) {
                skip++;
            }
            if (y < 0) {
                skip++;
            }
            if (z < 0) {
                skip++;
            }
            point3D = new Point3D(x, y, z);
        } catch (
                FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            throw new DAOException(e);
        } catch (NullPointerException e) {
            throw new DAOException(e);
        }
        return point3D;
    }

   /* public double distanceBetweenTwoPoints(Point3D point1, Point3D point2) {
        return Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2) +
                Math.pow(point1.getZ() - point2.getZ(), 2));
    }*/
}
