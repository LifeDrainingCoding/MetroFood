package com.lifedrained.metrofood.frontend.views.dialogs;

import com.lifedrained.metrofood.data.Addresses;
import com.lifedrained.metrofood.data.json.JsonPositions;
import com.lifedrained.metrofood.data.repo.OrderRepo;
import com.lifedrained.metrofood.data.repo.entity.Order;
import com.lifedrained.metrofood.data.repo.entity.Position;
import com.lifedrained.metrofood.frontend.views.widgets.*;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class DialogForm extends VerticalLayout {
   private final LinkedHashMap<Position, Integer> selectedPositions;
   private Checkbox checkbox;
   private CustomDateTimePicker datePicker;
   private RowWithTxtField deliveryAddress;
   private RowWithComboBox comboBox;

    public DialogForm(LinkedHashMap<Position, Integer> selectedPositions) {
        this.selectedPositions = selectedPositions;
        setAlignItems(Alignment.STRETCH);
        setWidth("600px");
        init();
    }

    private void init(){
        checkbox =  new Checkbox("Доставка");
        deliveryAddress =  new RowWithTxtField("Адрес доставки: ");
        comboBox = new RowWithComboBox("Адреса самовывоза: ",
                 Arrays.stream(Addresses.values()).toList());
        datePicker =  new CustomDateTimePicker("Выберите дату доставки");

        selectedPositions.forEach(((position, count) -> {
            CustomLabel label =  new CustomLabel(position.getName() +"  "+count+" шт.");
            add(label);
        }));

        checkbox.setValue(true);
        add(checkbox);
        add(deliveryAddress, datePicker);

        checkbox.addValueChangeListener(event -> {


            if (event.getValue()){
                remove(comboBox);
                addComponentAtIndex( getComponentCount()-1,deliveryAddress);
                datePicker.setLabel("Выберите дату доставки");
            }else {
                remove(deliveryAddress);
                addComponentAtIndex(getComponentCount()-1,comboBox);
                datePicker.setLabel("Выберите дату забора заказа");
            }
        });
    }
    public Order getOrder(){
        JsonPositions jsonPositions = new JsonPositions(selectedPositions);
        Order order =  new Order();
        order.setJsonPositions(Order.toJsonPositions(jsonPositions));
        order.setDate(datePicker.getDate());
        if (checkbox.getValue()){
            order.setDeliveryAddress(deliveryAddress.getFieldText());
            order.setRestaurantEnum(null);
        }else {
            order.setDeliveryAddress(null);
            order.setRestaurantEnum(comboBox.getBoxValue().name());
        }
        return order;
    }
}
