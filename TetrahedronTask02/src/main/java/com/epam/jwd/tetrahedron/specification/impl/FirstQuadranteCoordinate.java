package com.epam.jwd.tetrahedron.specification.impl;

import com.epam.jwd.tetrahedron.bean.Tetrahedron;
import com.epam.jwd.tetrahedron.service.impl.TetrahedronServiceImpl;
import com.epam.jwd.tetrahedron.specification.Specification;
import com.epam.jwd.tetrahedron.service.TetrahedronService;

public class FirstQuadranteCoordinate implements Specification<Tetrahedron> {
    TetrahedronService tetrahedronService;

    public FirstQuadranteCoordinate() {
        tetrahedronService = new TetrahedronServiceImpl();
    }

    @Override
    public boolean specify(Tetrahedron tetrahedron) {
        return tetrahedronService.isOnTheFirstQuadrante(tetrahedron);
    }
}
