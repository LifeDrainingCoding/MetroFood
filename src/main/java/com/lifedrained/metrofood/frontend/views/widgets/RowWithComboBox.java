package com.lifedrained.metrofood.frontend.views.widgets;

import com.lifedrained.metrofood.data.Addresses;
import com.vaadin.flow.component.ItemLabelGenerator;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.ArrayList;
import java.util.List;

public class RowWithComboBox extends HorizontalLayout {
    private ComboBox<Addresses> comboBox;
    private Span label;
    public RowWithComboBox(String text, List<Addresses> items){
        comboBox = new ComboBox<>();
        comboBox.setItems(items);
        comboBox.setItemLabelGenerator(item -> item.value);
        comboBox.setValue(items.get(0));
        comboBox.setMaxWidth(null);
        setMaxWidth(null);
        label = new Span(text);
        label.removeClassName(LumoUtility.Margin.Right.LARGE);
        label.addClassName(LumoUtility.Margin.Right.SMALL);

        add(label,comboBox);
    }

    public Addresses getBoxValue(){
        return comboBox.getValue();
    }
}
