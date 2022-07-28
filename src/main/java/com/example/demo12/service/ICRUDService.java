package com.example.demo12.service;

import java.util.ArrayList;

public interface ICRUDService<E> {
    E findById(int id);
    ArrayList<E> findAll();
    void create(E e);
    void update(E e);
    void deleteById(int id);
}
