package com.epam.jwd.tetrahedron.comparator;

import com.epam.jwd.tetrahedron.bean.Tetrahedron;

import java.util.Comparator;

public class IdComparator implements Comparator<Tetrahedron> {
    @Override
    public int compare(Tetrahedron obj1, Tetrahedron obj2) {
        return (int) (obj1.getId() - obj2.getId());
    }
}
