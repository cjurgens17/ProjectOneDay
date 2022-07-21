package com.utils;

public interface DAOInterface<T> {
    Integer create(T t);


    T read(Integer id);



    T update(T t);


    boolean delete(Integer id);


}
