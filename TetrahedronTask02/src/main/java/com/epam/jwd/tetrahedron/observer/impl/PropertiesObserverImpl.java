package com.epam.jwd.tetrahedron.observer.impl;

import com.epam.jwd.tetrahedron.bean.Tetrahedron;
import com.epam.jwd.tetrahedron.observer.Observer;
import com.epam.jwd.tetrahedron.service.TetrahedronService;
import com.epam.jwd.tetrahedron.service.impl.TetrahedronServiceImpl;

public class PropertiesObserverImpl implements Observer<Tetrahedron> {

    private TetrahedronService tetrahedronService;
    private double side;
    private double square;
    private double volume;

    public PropertiesObserverImpl() {
        tetrahedronService = new TetrahedronServiceImpl();
    }

    public double getSide() {
        return side;
    }

    public double getSquare() {
        return square;
    }

    public double getVolume() {
        return volume;
    }


    @Override
    public void handleEvent(Tetrahedron tetrahedron) {
        if(tetrahedronService.isTetrahedron(tetrahedron)) {
            side = tetrahedronService.calculateSide(tetrahedron);
            square = tetrahedronService.calculateSquare(side);
            volume = tetrahedronService.calculateVolume(side);
        }
    }
}
