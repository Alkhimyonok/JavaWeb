package com.epam.jwd.tetrahedron.util;

import com.epam.jwd.tetrahedron.bean.Point3D;
import com.epam.jwd.tetrahedron.util.exception.FileException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParserFigure {
    private static final String POINTS_SOURCE = "data\\input.txt";

    public Point3D toPoint3D(int pointNumber) throws FileException {
        Point3D point3D;
        try (BufferedReader reader = new BufferedReader(new FileReader(POINTS_SOURCE))) {
            String[] points = reader.readLine().split("; ");
            String[] pointInfo = points[pointNumber].split("\\s");
            int x, y, z;
            x = Integer.parseInt(pointInfo[0]);
            y = Integer.parseInt(pointInfo[1]);
            z = Integer.parseInt(pointInfo[2]);
            point3D = new Point3D(x, y, z);
        } catch (FileNotFoundException e) {
            throw new FileException(e);
        } catch (IOException e) {
            throw new FileException(e);
        } catch (NullPointerException e) {
            throw new FileException(e);
        }
        return point3D;
    }
}
