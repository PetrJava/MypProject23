package paymentsSystem.entity;

public class TypeOperationEntity {
    private Integer typeOperationId;
    private String type;

    public TypeOperationEntity(int typeOperationId, String type) {
        this.typeOperationId = typeOperationId;
        this.type = type;
    }

    public TypeOperationEntity() {
    }

    public int getTypeOperationId() {
        return typeOperationId;
    }

    public void setTypeOperationId(int typeOperationId) {
        this.typeOperationId = typeOperationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TypeOperation{" +
               "type_operation_id=" + typeOperationId +
               ", type='" + type + '\'' +
               '}';
    }
}
