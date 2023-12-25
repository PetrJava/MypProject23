package paymentsSystem.mapper;

public interface MapperToEntity<E, T> {
        T toEntity(E dto);
}


