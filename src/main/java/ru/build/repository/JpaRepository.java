package ru.build.repository;



import ru.build.entity.User;

import java.util.List;

public interface JpaRepository<T, ID> {
    List<T> getAll();

    User getById(ID id);

    void create(T entity);

    void update(ID id, T entity);

    void delete(T id);
}
