package com.epam.jwd.tetrahedron.observer.impl;

import com.epam.jwd.tetrahedron.bean.Tetrahedron;
import com.epam.jwd.tetrahedron.observer.Observable;
import com.epam.jwd.tetrahedron.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronObservableImpl implements Observable<Observer> {

    Tetrahedron tetrahedron;
    List<Observer> observers;

    public TetrahedronObservableImpl() {
        tetrahedron = new Tetrahedron();
        observers = new ArrayList<>();
    }

    public void setTetrahedron(Tetrahedron tetrahedron) {
        this.tetrahedron = tetrahedron;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
        notifyObservers();
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            obj.handleEvent(tetrahedron);
        }
    }
}
