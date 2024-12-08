package com.lifedrained.metrofood.data;

public enum Category {
    PIZZA("Пицца"), BURGERS("Бургеры"), DRINKS("Напитки" ),
    SHAURMA("Шаурма");
    public final String name;

    Category(String name) {
        this.name = name;
    }
}
