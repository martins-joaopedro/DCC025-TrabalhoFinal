package br.ufjf.services;

import java.util.List;

public interface IService<T> {
    
    T findById(String id);

    List<T> findAll();
    
    void create(T obj);

    void saveAll(List<T> obj);
}
