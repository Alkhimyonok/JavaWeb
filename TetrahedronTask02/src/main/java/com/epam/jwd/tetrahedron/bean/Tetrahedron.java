package com.epam.jwd.tetrahedron.bean;

import java.util.Objects;

public class Tetrahedron {
    private long id;
    private Point3D point1;
    private Point3D point2;
    private Point3D point3;
    private Point3D point4;

    public Tetrahedron() {
        point1 = new Point3D();
        point2 = new Point3D();
        point3 = new Point3D();
        point4 = new Point3D();
    }

    public Tetrahedron(Point3D point1, Point3D point2, Point3D point3, Point3D point4) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Point3D getPoint1() {
        return point1;
    }

    public void setPoint1(Point3D point1) {
        this.point1 = point1;
    }

    public Point3D getPoint2() {
        return point2;
    }

    public void setPoint2(Point3D point2) {
        this.point2 = point2;
    }

    public Point3D getPoint3() {
        return point3;
    }

    public void setPoint3(Point3D point3) {
        this.point3 = point3;
    }

    public Point3D getPoint4() {
        return point4;
    }

    public void setPoint4(Point3D point4) {
        this.point4 = point4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tetrahedron that = (Tetrahedron) o;
        return Objects.equals(point1, that.point1) &&
                Objects.equals(point2, that.point2) &&
                Objects.equals(point3, that.point3) &&
                Objects.equals(point4, that.point4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1, point2, point3, point4);
    }

    @Override
    public String toString() {
        return "Tetrahedron{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                ", point3=" + point3 +
                ", point4=" + point4 +
                '}';
    }
}
