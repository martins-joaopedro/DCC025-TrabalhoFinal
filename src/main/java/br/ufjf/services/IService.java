package br.ufjf.services;

/*
 * autores:
    João Pedro Martins Cruz, 202365552C
    Júlia Zoffoli Caçador, 202365520B
    Robert Gonçalves Vieira de Souza, 202365505B
 */

import java.util.List;

public interface IService<T> {
    
    T findById(String id);

    List<T> findAll();
    
    void create(T obj);

    void saveAll(List<T> obj);
}
