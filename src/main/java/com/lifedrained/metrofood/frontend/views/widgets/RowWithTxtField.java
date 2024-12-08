package com.lifedrained.metrofood.frontend.views.widgets;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignSelf;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;


public class RowWithTxtField extends HorizontalLayout {
   private final TextField textField;
   private final CustomLabel label;
    public RowWithTxtField(String text){
        super();

        textField = new TextField();
        label = new CustomLabel(text);
        label.removeClassName(Margin.Right.LARGE);
        label.addClassName(Margin.Right.SMALL);
        addClassNames(AlignSelf.BASELINE);
        setMaxWidth(null);
        add(label,textField);
    }
    public String getFieldText(){
        return textField.getValue();
    }

    public void setLabelWidth(String w){
        label.setWidth(w);
        label.setMaxWidth(null);
    }
    public void setLabelHeight(String h){
        label.setHeight(h);
        label.setMaxHeight("40px");
    }
    public void setLabelHeight(String h, String mh){
        label.setHeight(h);
        label.setMaxHeight(mh);
    }
    public TextField getBody(){
        return textField;
    }
}
