package com.epam.jwd.tetrahedron.repository.impl;

import com.epam.jwd.tetrahedron.bean.Tetrahedron;
import com.epam.jwd.tetrahedron.observer.Observer;
import com.epam.jwd.tetrahedron.observer.impl.PropertiesObserverImpl;
import com.epam.jwd.tetrahedron.observer.impl.TetrahedronObservableImpl;
import com.epam.jwd.tetrahedron.repository.Repository;
import com.epam.jwd.tetrahedron.specification.Specification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TetrahedronRepository implements Repository<Tetrahedron> {
    private List<Tetrahedron> tetrahedronList;
    private Map<Long, Observer<Tetrahedron>> tetrahedronMap;

    public TetrahedronRepository() {
        tetrahedronList = new ArrayList<>();
        tetrahedronMap = new HashMap<>();
    }

    public void addTetrahedron(Tetrahedron tetrahedron) {
        tetrahedronList.add(tetrahedron);
        PropertiesObserverImpl properties = new PropertiesObserverImpl();
        TetrahedronObservableImpl tetrahedronObservable = new TetrahedronObservableImpl();
        tetrahedronObservable.setTetrahedron(tetrahedron);
        tetrahedronObservable.addObserver(properties);
        tetrahedronMap.put(tetrahedron.getId(), properties);
    }

    public void updateTetrahedron(Tetrahedron newTetrahedron) {
        int positionTetrahedron = -1;
        for (int i = 0; i < tetrahedronList.size(); i++) {
            if (tetrahedronList.get(i).getId() == newTetrahedron.getId()) {
                positionTetrahedron = i;
            }
        }
        tetrahedronList.set(positionTetrahedron, newTetrahedron);
        Observer<Tetrahedron> properties = tetrahedronMap.get(newTetrahedron.getId());
        TetrahedronObservableImpl tetrahedronObservable = new TetrahedronObservableImpl();
        tetrahedronObservable.setTetrahedron(newTetrahedron);
        tetrahedronObservable.addObserver(properties);
        tetrahedronMap.put(newTetrahedron.getId(), properties);
    }

    public void removeTetrahedron(Tetrahedron tetrahedron) {
        tetrahedronList.remove(tetrahedron);
        tetrahedronMap.remove(tetrahedron.getId());
    }

    public List<Tetrahedron> search(Specification specification) {
        List<Tetrahedron> specificationList = new ArrayList<>();
        for (Tetrahedron obj : tetrahedronList) {
            if (specification.specify(obj)) {
                specificationList.add(obj);
            }
        }
        return specificationList;
    }
}