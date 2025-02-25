package org.jordan.domain.criteria;

public enum Operator {
    EQUAL("="),
    NOT_EQUAL("!="),
    GT(">"),
    LT("<"),
    CONTAINS("CONTAINS"),
    NOT_CONTAINS("NOT_CONTAINS");
    private final String value;
    Operator(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
    public static Operator fromValue(String value) {
        for (Operator op : Operator.values()) {
            if (op.value.equals(value)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Operador no válido: " + value);
    }
}
