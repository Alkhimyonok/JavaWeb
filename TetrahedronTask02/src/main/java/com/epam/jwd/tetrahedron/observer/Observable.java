package com.epam.jwd.tetrahedron.observer;

public interface Observable<O>{
        void addObserver(O o);
        void removeObserver(O o);
        void notifyObservers();
        }