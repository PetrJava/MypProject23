package paymentsSystem.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<K, E> {

    boolean delete(K id);
    void update(E entity);
    E save(E entity);
    Optional<E> findById(K id);
    List<E> findAll();
}
