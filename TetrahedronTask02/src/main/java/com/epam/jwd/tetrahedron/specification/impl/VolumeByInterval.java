package com.epam.jwd.tetrahedron.specification.impl;

import com.epam.jwd.tetrahedron.bean.Tetrahedron;
import com.epam.jwd.tetrahedron.service.TetrahedronService;
import com.epam.jwd.tetrahedron.service.impl.TetrahedronServiceImpl;
import com.epam.jwd.tetrahedron.specification.Specification;

public class VolumeByInterval implements Specification<Tetrahedron> {
    TetrahedronService tetrahedronService;
    int minVolume;
    int maxVolume;

    public VolumeByInterval(int minVolume, int maxVolume) {
        tetrahedronService = new TetrahedronServiceImpl();
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    public boolean specify(Tetrahedron tetrahedron) {
        double side = tetrahedronService.calculateSide(tetrahedron);
        double volume = tetrahedronService.calculateVolume(side);
        return volume >= minVolume && volume <= maxVolume;
    }
}
