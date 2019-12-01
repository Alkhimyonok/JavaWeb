package com.epam.jwd.tetrahedron;

import com.epam.jwd.tetrahedron.bean.Point3D;
import com.epam.jwd.tetrahedron.bean.Tetrahedron;
import com.epam.jwd.tetrahedron.repository.impl.TetrahedronRepository;
import com.epam.jwd.tetrahedron.service.TetrahedronService;
import com.epam.jwd.tetrahedron.service.exception.ServiceException;
import com.epam.jwd.tetrahedron.service.impl.TetrahedronServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        TetrahedronService tetrahedronService = new TetrahedronServiceImpl();
        Tetrahedron tetrahedron = new Tetrahedron();
        try {
            tetrahedron = tetrahedronService.createTetrahedron();
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        LOGGER.info(tetrahedron.toString());
        TetrahedronRepository tetrahedronRepository = new TetrahedronRepository();
        tetrahedronRepository.addTetrahedron(tetrahedron);
        tetrahedronService.changeTetrahedronPoint1(1, 1, 1, tetrahedron, tetrahedronRepository);
        Tetrahedron tetrahedron1 = new Tetrahedron(new Point3D(1, 2, 3), new Point3D(4, 5, 6), new Point3D(7, 8, 9), new Point3D(1, 5, 3));
        tetrahedron1.setId(1);
        tetrahedronRepository.addTetrahedron(tetrahedron1);
        tetrahedronService.changeTetrahedronPoint1(1, 1, 1, tetrahedron1, tetrahedronRepository);
        tetrahedronService.changeTetrahedronPoint2(-1, -1, 1, tetrahedron1, tetrahedronRepository);
        tetrahedronService.changeTetrahedronPoint3(-1, 1, -1, tetrahedron1, tetrahedronRepository);
        tetrahedronService.changeTetrahedronPoint4(1, -1, -1, tetrahedron1, tetrahedronRepository);
    }
}
