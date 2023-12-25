package paymentsSystem.mapper;

public interface MapperToDto<E, T> {

    T toDto(E entity);

}


