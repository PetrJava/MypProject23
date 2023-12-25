package paymentsSystem.entity;

import java.util.Objects;

public class TypeOperationEntity {
    private Integer typeOperationId;
    private String type;

    public TypeOperationEntity(int typeOperationId, String type) {
        this.typeOperationId = typeOperationId;
        this.type = type;
    }

    public TypeOperationEntity(String type) {
        this.type = type;
    }

    public TypeOperationEntity() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTypeOperationId() {
        return typeOperationId;
    }

    public void setTypeOperationId(Integer typeOperationId) {
        this.typeOperationId = typeOperationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeOperationEntity that = (TypeOperationEntity) o;
        return Objects.equals(typeOperationId, that.typeOperationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOperationId);
    }

    @Override
    public String toString() {
        return "TypeOperationDto{" +
               "type='" + type + '\'' +
               ", typeOperationId=" + typeOperationId +
               '}';
    }
}
