package ru.build.repository.impl;

import ru.build.entity.User;
import ru.build.repository.JpaRepository;

import java.util.List;

public class JpaRepositoryImpl<T, ID> implements JpaRepository<T, ID> {


    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public User getById(ID id) {
        return null;
    }

    @Override
    public void create(T entity) {

    }

    @Override
    public void update(ID id, T entity) {

    }

    @Override
    public void delete(T id) {

    }
}
