package io.compiler.types;

public enum Types {
    NUMBER(1),
    TEXT(2);

    private int value;

    private Types(int ValueNumber) {
        this.value = ValueNumber;
    }
    public Integer getValue() {
        return this.value;
    }
}
