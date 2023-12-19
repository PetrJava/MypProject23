package paymentsSystem.mapper;

public interface BaseMapper<E, T> {

    T toDto(E entity);
}


