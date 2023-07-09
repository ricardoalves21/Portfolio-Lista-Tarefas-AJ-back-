package com.ricardo.enums;

public enum Etapa {

    AFAZER("etapa1"),
    FAZENDO("etapa2"),
    FEITO("etapa3");

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
