package com.epam.jwd.tetrahedron.repository;

import com.epam.jwd.tetrahedron.specification.Specification;

import java.util.List;

public interface Repository<T> {
    void addTetrahedron(T t);

    void updateTetrahedron(T t);

    void removeTetrahedron(T t);

    List<T> search(Specification<T> specification);
}
