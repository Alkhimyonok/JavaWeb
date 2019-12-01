package com.epam.jwd.tetrahedron;

import com.epam.jwd.tetrahedron.bean.Tetrahedron;
import com.epam.jwd.tetrahedron.service.Point3DService;
import com.epam.jwd.tetrahedron.service.TetrahedronService;
import com.epam.jwd.tetrahedron.service.exception.ServiceException;
import com.epam.jwd.tetrahedron.service.impl.Point3DServiceImpl;
import com.epam.jwd.tetrahedron.service.impl.TetrahedronServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class TetrahedronTest {
    private static Tetrahedron tetrahedron;
    private static Point3DService point3DService;
    private static TetrahedronService tetrahedronService;
    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    @BeforeClass
    public static void initTetrahedronTest() {
        point3DService = new Point3DServiceImpl();
        tetrahedronService = new TetrahedronServiceImpl();
        try {
            tetrahedron = tetrahedronService.createTetrahedron();
        } catch (ServiceException e) {
            LOGGER.error("ERROR!");
        }
    }

    @Test
    public void isTetrahedronTest() {
        Assert.assertTrue("Not a tetrahedron.", tetrahedronService.isTetrahedron(tetrahedron));
    }

    @Test
    public void onCoordinatePlane() {
        Assert.assertTrue("Doesn't on the coordinate plane.", tetrahedronService.onCoordinatePlane(tetrahedron));
    }
}
