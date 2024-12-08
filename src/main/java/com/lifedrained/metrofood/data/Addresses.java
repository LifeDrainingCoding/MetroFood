package com.lifedrained.metrofood.data;

public enum Addresses {
    FIRST ("Уютное кафе ул. Краснормейская, 188/2 с 9:00 до 21:00"),
    SECOND ( "Быстро и вкусно ул. Пионерская, 40/1 с 9:00 до 23:00");

    public final String value;

    Addresses(String value) {
        this.value = value;
    }
}
