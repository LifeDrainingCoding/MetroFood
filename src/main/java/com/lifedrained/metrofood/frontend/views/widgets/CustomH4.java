package com.lifedrained.metrofood.frontend.views.widgets;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.theme.lumo.LumoUtility;


public class CustomH4 extends H4 {
    private String text;

    public CustomH4(String text) {
        super(text);
        this.text = text;
        addClassName(LumoUtility.Margin.Right.SMALL);
        setMaxHeight(null);
        getStyle().set("word-wrap", "break-word");
    }
}
