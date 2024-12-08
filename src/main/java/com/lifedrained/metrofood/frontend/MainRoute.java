package com.lifedrained.metrofood.frontend;

import com.lifedrained.metrofood.data.repo.OrderRepo;
import com.lifedrained.metrofood.data.repo.PositionRepo;
import com.lifedrained.metrofood.data.repo.entity.Position;
import com.lifedrained.metrofood.frontend.views.BackgroundLayout;
import com.lifedrained.metrofood.frontend.views.Menu;
import com.lifedrained.metrofood.frontend.views.ViewIds;
import com.lifedrained.metrofood.utils.PositionUtils;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Route("/")
public class MainRoute extends VerticalLayout   {
    private PositionRepo repo;
    private OrderRepo orderRepo;

    public MainRoute(PositionRepo repo, OrderRepo orderRepo) {
        this.repo = repo;
        this.orderRepo = orderRepo;

        initialize();
        addClassNames(LumoUtility.Margin.NONE,
                LumoUtility.Padding.NONE);
        UI.getCurrent().addShortcutListener(event -> {
            PositionUtils.updatePositions(repo);

        }, Key.KEY_U, KeyModifier.SHIFT, KeyModifier.META);
    }


    public void initialize(){
        add(new BackgroundLayout(ViewIds.MENU));
        add(new Menu(repo, orderRepo));
    }
}
