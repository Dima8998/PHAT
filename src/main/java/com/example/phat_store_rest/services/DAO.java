package com.example.phat_store_rest.services;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    T save(T t);
    Optional<T> findById(Integer id);
    List<T> findAll();
}
