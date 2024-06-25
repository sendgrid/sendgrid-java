package com.sendgrid.constant;

public enum Domains {
    API("api");
    private final String value;

    private Domains(final String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
