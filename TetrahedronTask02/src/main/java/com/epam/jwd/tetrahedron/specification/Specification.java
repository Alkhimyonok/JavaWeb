package com.epam.jwd.tetrahedron.specification;

public interface Specification<T> {
    boolean specify(T t);
}
