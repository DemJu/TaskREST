package ru;

import lombok.Data;

@Data
public final class ReturnClass {
    private Object[] firstMas;
    private Object first;
    private Object second;

    public ReturnClass(Object[] firstMas, Object second) {
        this.firstMas = firstMas;
        this.second = second;
    }

    public ReturnClass(Object first, Object second) {
        this.first = first;
        this.second = second;
    }
}
