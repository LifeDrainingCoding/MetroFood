package com.lifedrained.metrofood.data;

public enum Categories {
    PIZZA("Пицца"), BURGERS("Бургеры"), DRINKS("Напитки" ),
    SHAURMA("Шаурма");
    public final String name;

    Categories(String name) {
        this.name = name;
    }
}
