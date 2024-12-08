package com.lifedrained.metrofood.utils;

import com.vaadin.flow.dom.Element;

public class JSUtils {
    public static void scrollToElement(Element element, String elementId){
        element.executeJs(
                "document.getElementById('"+elementId+"').scrollIntoView({ behavior: 'smooth' });"
        );
    }
}
