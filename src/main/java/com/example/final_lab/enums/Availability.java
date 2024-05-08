package com.example.final_lab.enums;

public enum Availability {
    ACCESSIBLE("Есть на складе."),
    UNAVAILABLE("Нет в наличии.");

    Availability(String label) {
        this.label = label;
    }

    public final String label;
}
