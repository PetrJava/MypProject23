package myProject.dao;

import myProject.entity.Client;

import java.util.List;
import java.util.Optional;

public interface Dao<K, E> {

    boolean delete(K id);
    void update(E client);
    Client save(E client);
    Optional<E> findById(K id);
    List<E> findAll();
}
