package com.epam.jwd.tetrahedron.comparator;

import com.epam.jwd.tetrahedron.bean.Tetrahedron;

import java.util.Comparator;

public class XFirstPointComparator implements Comparator<Tetrahedron> {
    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        if (o1.getPoint1().getX() < o2.getPoint1().getX()) {
            return -1;
        }
        if (o1.getPoint1().getX() > o2.getPoint1().getX()) {
            return 1;
        } else return 0;
    }
}