package org.jordan.domain.criteria;

public enum OrderTypes {
    ASC("asc"),
    DESC("desc"),
    NONE("none");
    private final String value;
    OrderTypes(String value){this.value=value;}
    @Override
    public String toString() {
        return value;
    }
    public static OrderTypes fromValue(String value) {
        for (OrderTypes op : OrderTypes.values()) {
            if (op.value.equals(value)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Operador no válido: " + value);
    }
}
