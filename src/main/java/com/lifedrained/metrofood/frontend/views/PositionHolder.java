package com.lifedrained.metrofood.frontend.views;

import com.lifedrained.metrofood.data.repo.entity.Position;
import com.lifedrained.metrofood.frontend.views.widgets.CustomH4;
import com.lifedrained.metrofood.frontend.views.widgets.CustomLabel;
import com.lifedrained.metrofood.utils.LumoUtils;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;

public class PositionHolder extends VerticalLayout  {
    private static final Logger log = LogManager.getLogger(PositionHolder.class);
    private final List<Position> positions;
    private final OnPositionAddedListener listener;

    public PositionHolder(List<Position> positions, OnPositionAddedListener listener) {
        this.positions = positions;
        this.listener = listener;
        addClassName(LumoUtility.Background.TRANSPARENT);
        initialize();
    }


    public void initialize() {
        HorizontalLayout currentRow = new HorizontalLayout(){{
            addClassNames(LumoUtility.Background.TRANSPARENT,
                    LumoUtility.Border.TOP, LumoUtility.Border.BOTTOM);
        }};
        for (int i = 0; i <positions.size() ; i++) {
            Position position = positions.get((i));
            VerticalLayout layout = new VerticalLayout();
            layout.addClassNames(LumoUtility.Display.FLEX, LumoUtility.Background.TRANSPARENT);

            Image image = new Image();
            image.setMaxHeight("230px");
            image.setMaxWidth("260px");
            layout.setAlignItems(Alignment.STRETCH);
            layout.setMaxWidth("260px");
            layout.setHeight(230*3.5f,Unit.PIXELS);

            StreamResource resource = new StreamResource("position " + position.getName(),  () -> {
                return getClass().getResourceAsStream("/static/images/"+position.getImgPath());
            });
            image.setSrc(resource);

            CustomH4 name,price;

            name = new CustomH4(position.getName());
            name.addClassNames(LumoUtility.Flex.GROW, LumoUtility.Background.TRANSPARENT);

            price =  new CustomH4(position.getPrice() +" р.");
            price.addClassNames(LumoUtility.Flex.GROW, LumoUtility.Background.TRANSPARENT);

            CustomLabel description = new CustomLabel(position.getDescription());


            VerticalLayout descriptionLayout = new VerticalLayout(description){{
                addClassNames(LumoUtility.Padding.NONE, LumoUtility.Margin.NONE);
                LumoUtils.shrink(this);
                addClassName(LumoUtility.Overflow.SCROLL);
            }};
            description.addClassNames(LumoUtility.Flex.SHRINK, LumoUtility.Background.TRANSPARENT);
            IntegerField count = getIntegerField(position);
            LumoUtils.grow(count);

            VerticalLayout spacer =  new VerticalLayout(){{
                addClassNames(LumoUtility.Flex.SHRINK, LumoUtility.Background.TRANSPARENT);
                addClassNames(LumoUtility.Padding.NONE, LumoUtility.Margin.NONE);
            }};

            layout.add(image);
            layout.add(name);
            layout.add(descriptionLayout);
            layout.add(price);
            layout.add(spacer);
            layout.add(count);


            if (i % 4 == 0){
                currentRow = new HorizontalLayout(){{
                    addClassNames(LumoUtility.Background.TRANSPARENT,
                        LumoUtility.Border.TOP, LumoUtility.Border.BOTTOM);
                }};

                currentRow.add(layout);
                add(currentRow);
            }

            currentRow.add(layout);
            if (i == positions.size()-1){
                add(currentRow);
            }
        }
    }

    private IntegerField getIntegerField(Position position) {
        IntegerField count = new IntegerField();
        count.setValue(0);
        count.setStepButtonsVisible(true);
        count.addClassNames(
                LumoUtility.AlignSelf.CENTER,
                LumoUtility.Background.TRANSPARENT);
        count.addValueChangeListener(event -> {
            listener.onPositionAdded(position, event.getValue());
        });
        count.setMin(0);
        return count;
    }
}
