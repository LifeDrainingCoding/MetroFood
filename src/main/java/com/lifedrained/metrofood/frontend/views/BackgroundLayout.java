package com.lifedrained.metrofood.frontend.views;

import com.lifedrained.metrofood.utils.JSUtils;
import com.lifedrained.metrofood.utils.LumoUtils;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.apache.commons.configuration2.Initializable;

import static com.vaadin.flow.theme.lumo.LumoUtility.Background.TRANSPARENT;

public class BackgroundLayout extends VerticalLayout  {

    private  final String navigationId;

    public BackgroundLayout(String navigationId) {
        this.navigationId = navigationId;
        getStyle().setBackgroundColor("#333333");

        initialize();
    }

    public void initialize() {

        StreamResource resource  = new StreamResource("background.png", () ->{
            return getClass().getResourceAsStream("/static/images/background.png");
        });
        Image image =  new Image();
        image.setSrc(resource);
        image.addClassName(LumoUtility.ZIndex.NONE);
        image.setHeight("540px");
        image.setWidthFull();
        image.addClassName(LumoUtility.Flex.SHRINK);



        setAlignItems(Alignment.CENTER);
        HorizontalLayout btnLayout =  new HorizontalLayout(new Button("Перейти к меню"){{
            addClassName(LumoUtility.ZIndex.SMALL);
            addClassName(LumoUtility.AlignSelf.CENTER);
            addClassNames(LumoUtility.TextColor.PRIMARY_CONTRAST,
                    LumoUtility.FontSize.LARGE);
        }}){{
            LumoUtils.grow(this);
            addClassNames(
                    LumoUtility.ZIndex.SMALL);
            setAlignItems(Alignment.CENTER);

            addClickListener(event -> {
                JSUtils.scrollToElement(getElement(),navigationId);
            });
        }};

        add(image,btnLayout);


    }
}
