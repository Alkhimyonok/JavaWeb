package com.epam.jwd.tetrahedron.bean;

import java.util.Arrays;
import java.util.Objects;

public class Tetrahedron {
    private Point3D[] points;
    private double side;
    private double square;
    private double volume;

    public Tetrahedron() {
    }

    public Tetrahedron(Point3D[] points) {
        this.points = points;
    }

    public Tetrahedron(Point3D[] points, double side, double square, double volume) {
        this.points = points;
        this.side = side;
        this.square = square;
        this.volume = volume;
    }

    public Point3D[] getPoints() {
        return points;
    }

    public void setPoints(Point3D[] points) {
        this.points = points;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tetrahedron that = (Tetrahedron) o;
        return Double.compare(that.side, side) == 0 &&
                Double.compare(that.square, square) == 0 &&
                Double.compare(that.volume, volume) == 0 &&
                Arrays.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(side, square, volume);
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    @Override
    public String toString() {
        return "Tetrahedron{" +
                "points=" + Arrays.toString(points) +
                ", side=" + side +
                ", square=" + square +
                ", volume=" + volume +
                '}';
    }
}
