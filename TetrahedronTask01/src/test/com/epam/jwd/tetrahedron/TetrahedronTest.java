package test.com.epam.jwd.tetrahedron;

import com.epam.jwd.tetrahedron.bean.Point3D;
import com.epam.jwd.tetrahedron.dao.exception.DAOException;
import com.epam.jwd.tetrahedron.service.Point3DService;
import com.epam.jwd.tetrahedron.service.factory.ServiceFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class TetrahedronTest {
    private static final String POINT_SOURCE = "src\\test\\resources\\dataBase.txt";
    private static Point3D[] points;
    private static Point3DService point3DService;

    @BeforeClass
    public static void initTetrahedronTest() throws DAOException {
        point3DService = ServiceFactory.getInstance().getPoint3DService();
        points = new Point3D[4];
        for (int i = 0; i < 4; i++) {
            points[i] = point3DService.createPoint(POINT_SOURCE, i);
        }
    }

    @Test
    public void isTetrahedronTest() {
        double side01 = point3DService.distanceBetweenTwoPoints(points[0], points[1]);
        double side02 = point3DService.distanceBetweenTwoPoints(points[0], points[2]);
        double side03 = point3DService.distanceBetweenTwoPoints(points[0], points[3]);
        double side12 = point3DService.distanceBetweenTwoPoints(points[1], points[2]);
        double side13 = point3DService.distanceBetweenTwoPoints(points[1], points[3]);
        double side23 = point3DService.distanceBetweenTwoPoints(points[2], points[3]);
        boolean condition = (side01 == side02) && (side02 == side03) && (side03 == side12) && (side12 == side13) && (side13 == side23);
        Assert.assertTrue("Not a tetrahedron.",condition);
    }
}
