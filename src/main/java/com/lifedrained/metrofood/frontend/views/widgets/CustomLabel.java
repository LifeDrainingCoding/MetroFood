package com.lifedrained.metrofood.frontend.views.widgets;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class CustomLabel extends Span {
    public CustomLabel(String label){
        super(label);
        addClassName(LumoUtility.Margin.Right.SMALL);
        setMaxHeight(null);
        getStyle().set("word-wrap", "break-word");

    }
    public void setWidth(int width){
        super.setWidth(width, Unit.PIXELS);
        setMaxWidth(width, Unit.PIXELS);
    }
    public void setMaxHeight(int height){
        setMaxHeight(height, Unit.PIXELS);
    }
}
