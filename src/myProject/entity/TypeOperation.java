package myProject.entity;

public class TypeOperation {
    private int type_operation_id;
    private String type;

    public TypeOperation(int type_operation_id, String type) {
        this.type_operation_id = type_operation_id;
        this.type = type;
    }

    public TypeOperation() {
    }

    public int getType_operation_id() {
        return type_operation_id;
    }

    public void setType_operation_id(int type_operation_id) {
        this.type_operation_id = type_operation_id;
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
               "type_operation_id=" + type_operation_id +
               ", type='" + type + '\'' +
               '}';
    }
}
