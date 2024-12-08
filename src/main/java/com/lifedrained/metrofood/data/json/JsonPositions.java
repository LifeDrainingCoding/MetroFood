package com.lifedrained.metrofood.data.json;

import com.lifedrained.metrofood.data.repo.entity.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.LinkedHashMap;


@NoArgsConstructor
@Getter @Setter
public class OrderJson implements Serializable {


    private double price = 0;
    private int positionsCount = 0;
    private LinkedHashMap<Position, Integer> positions;

    public OrderJson(LinkedHashMap<Position, Integer> positions) {
        this.positions = positions;
        positions.forEach((position, count) -> {
            positionsCount = positionsCount + count;
            price = position.getPrice() * count + price;
        });
    }
}
