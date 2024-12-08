package com.lifedrained.metrofood.utils;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class LumoUtils {
    public static void shrink (Component component){
        component.addClassName(LumoUtility.Flex.SHRINK);
    }
    public static void grow(Component component){
        component.addClassName(LumoUtility.Flex.GROW);
    }
    public static void absolute(Component component){
        component.addClassName(LumoUtility.Position.ABSOLUTE);
    }
}
