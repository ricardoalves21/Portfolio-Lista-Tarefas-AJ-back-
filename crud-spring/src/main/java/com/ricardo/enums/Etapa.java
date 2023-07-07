package com.ricardo.enums;

public enum Etapa {

    AFAZER("a fazer"),
    FAZENDO("fazendo"),
    FEITO("feito");

    private final String value;

    private Etapa(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Etapa{" +
                "value='" + value + '\'' +
                '}';
    }
}
