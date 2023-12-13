package myProject.dao;

import myProject.entity.ClientEntity;

import java.util.List;
import java.util.Optional;

public interface Dao<K, E> {

    boolean delete(K id);
    void update(E client);
    ClientEntity save(E client);
    Optional<E> findById(K id);
    List<E> findAll();
}
