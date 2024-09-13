package io.compiler.types;

public enum Types {
    REAL(1),
    NUMBER(2),
    TEXT(3);

    private int value;

    private Types(int ValueNumber) {
        this.value = ValueNumber;
    }
    public Integer getValue() {
        return this.value;
    }
}
