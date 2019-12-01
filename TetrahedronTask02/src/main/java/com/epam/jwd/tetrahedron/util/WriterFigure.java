package com.epam.jwd.tetrahedron.util;

import com.epam.jwd.tetrahedron.bean.Tetrahedron;
import com.epam.jwd.tetrahedron.util.exception.FileException;

import java.io.*;

public class WriterFigure {
    private static final String TETRAHEDRON_SOURCE = "data\\output.txt";

    public void writeTetrahedron(Tetrahedron tetrahedron) throws FileException {
        String tetrahedronInfo = tetrahedron.getPoint1().toString() + " " + tetrahedron.getPoint2().toString() +
                tetrahedron.getPoint3().toString() + tetrahedron.getPoint4().toString();
        try (FileWriter fileWriter = new FileWriter(new File(TETRAHEDRON_SOURCE));
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(tetrahedronInfo);
        } catch (FileNotFoundException e) {
            throw new FileException(e);

        } catch (IOException e) {
            throw new FileException(e);
        }
    }
}
