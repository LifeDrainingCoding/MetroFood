package com.lifedrained.metrofood.data.repo.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifedrained.metrofood.data.json.JsonPositions;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.Date;

@Entity
@Table(name = "orders", schema = "app")
@NoArgsConstructor
@Getter @Setter
public class Order {
    @Column(name = "id") @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "date", nullable = false) @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "isDelivery", nullable = false)
    private boolean isDelivery;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column (name = "restaurant_enum")
    private String restaurantEnum;

    @Column(name = "json_positions" , columnDefinition = "LONG VARCHAR", nullable = false)
    private String jsonPositions;

    public Order(Date date, String jsonPositions, boolean isDelivery, @Nullable String deliveryAddress
                 ,@Nullable String restaurantEnum) {
        this.date = date;
        this.jsonPositions = jsonPositions;
        this.isDelivery = isDelivery;
        this.deliveryAddress = deliveryAddress;
        this.restaurantEnum = restaurantEnum;
    }

    public static String toJsonPositions(JsonPositions jsonPositions){
        return new Gson().toJson(jsonPositions);
    }
    public static JsonPositions toObjectPositions(String jsonPositions){
        return new Gson().fromJson(jsonPositions,new TypeToken<JsonPositions>(){}.getType());
    }

}
