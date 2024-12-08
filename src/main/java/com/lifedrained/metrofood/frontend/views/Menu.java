package com.lifedrained.metrofood.frontend.views;

import com.lifedrained.metrofood.data.Category;
import com.lifedrained.metrofood.data.repo.OrderRepo;
import com.lifedrained.metrofood.data.repo.PositionRepo;
import com.lifedrained.metrofood.data.repo.entity.Position;
import com.lifedrained.metrofood.frontend.views.dialogs.OrderDialog;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.tabs.TabSheetVariant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Menu extends VerticalLayout implements  OnPositionAddedListener {
    private static final Logger log = LogManager.getLogger(Menu.class);

    private final PositionRepo repo;
    private final OrderRepo orderRepo;

    private final List<Category> categories = List.of(Category.values());
    private LinkedHashMap<Position, Integer> selectedPositions;

    public Menu(PositionRepo repo, OrderRepo orderRepo) {
        this.repo = repo;
        this.orderRepo = orderRepo;

        getStyle().setBackgroundColor("rgba(224,224,224,1)");
        setId(ViewIds.MENU);
        setAlignItems(Alignment.STRETCH);
        initialize();
    }


    public void initialize() {
        selectedPositions = new LinkedHashMap<>();
        ArrayList<Tab> tabs =  new ArrayList<>();
        TabSheet tabSheet =  new TabSheet();
        Button buyBtn =  new Button();
        buyBtn.setIcon(VaadinIcon.CART.create());
        buyBtn.addClickListener( event -> {
            OrderDialog orderDialog = new OrderDialog(null, selectedPositions, orderRepo);
            orderDialog.open();
        });

        tabSheet.setSuffixComponent(buyBtn);

        categories.forEach(category -> {
            Tab categoryTab = new Tab(category.name){{
                setId(category.name());
            }};
            tabs.add(categoryTab);
        });

        List<Position> positions = repo.findAll();

        tabs.forEach(tab -> {
           List<Position> categoryPositions  = positions.stream().filter(position -> {

               log.info("comparing {} to {}",position.getCategory(), tab.getId().get());
               return position.getCategory().equals(tab.getId().get());

            }).toList();
            log.info("matched entries count: {}", categoryPositions.size());
           tabSheet.add(tab, new PositionHolder(categoryPositions, this));
        });

        tabSheet.addThemeVariants(TabSheetVariant.LUMO_TABS_EQUAL_WIDTH_TABS);

        add(tabSheet);

    }

    @Override
    public void onPositionAdded(Position position, int count) {
        if (count > 0){
            selectedPositions.put(position, count);
        }else {
            selectedPositions.remove(position);
        }
    }
}
