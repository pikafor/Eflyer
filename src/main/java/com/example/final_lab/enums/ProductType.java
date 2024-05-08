package com.example.final_lab.enums;

public enum ProductType {
    PHONES("Телефоны"),
    LAPTOPS("Ноутбуки"),
    HEADPHONES("Наушники");

    ProductType(String label){this.label = label;}

    public final String label;
}
