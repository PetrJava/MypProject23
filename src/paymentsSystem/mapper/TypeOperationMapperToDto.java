package paymentsSystem.mapper;

import lombok.Getter;
import paymentsSystem.dto.TypeOperationDto;
import paymentsSystem.entity.TypeOperationEntity;

public class TypeOperationMapperToDto implements MapperToDto<TypeOperationEntity, TypeOperationDto> {
    @Getter
    private static final TypeOperationMapperToDto INSTANCE = new TypeOperationMapperToDto();

    @Override
    public TypeOperationDto toDto(TypeOperationEntity entity) {
        return TypeOperationDto.builder()
                .type(entity.getType()).build();
    }
}
