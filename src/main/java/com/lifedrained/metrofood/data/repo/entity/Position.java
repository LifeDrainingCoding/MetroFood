package com.lifedrained.metrofood.data.repo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Locale;

@Entity
@Getter @Setter
@Table(name = "positions", schema = "app")
@NoArgsConstructor
public class Position implements Serializable {

    @Id @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "LONG VARCHAR")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "category")
    private String category;

    @Column(name = "image_path")
    private String imgPath;

    public Position(String name, String description, double price, String category, String imgPath) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category.toUpperCase();
        this.imgPath = imgPath;
    }

}
