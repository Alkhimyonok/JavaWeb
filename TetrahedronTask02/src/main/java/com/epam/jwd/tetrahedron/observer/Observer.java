package com.epam.jwd.tetrahedron.observer;

public interface Observer<T> {
    void handleEvent(T t);
}