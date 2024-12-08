package com.lifedrained.metrofood.frontend.views.dialogs;

import com.lifedrained.metrofood.data.repo.OrderRepo;
import com.lifedrained.metrofood.data.repo.entity.Order;
import com.lifedrained.metrofood.data.repo.entity.Position;
import com.lifedrained.metrofood.utils.Notify;
import org.springframework.lang.Nullable;

import java.util.LinkedHashMap;

public class OrderDialog extends BaseDialog<DialogEvent>{
    private DialogEvent event = null;
    private DialogForm dialogForm;
    private OrderRepo repo;
    public OrderDialog( @Nullable OnConfirmDialogListener<DialogEvent> confirmListener,
                       LinkedHashMap<Position, Integer > selectedPositions, OrderRepo orderRepo) {
        super(confirmListener);
        dialogForm = new DialogForm(selectedPositions);
        getHeader().add(dialogForm);
        repo = orderRepo;
    }

    @Override
    public DialogEvent getDataFromFields() {
        return event;
    }

    @Override
    protected void setButtonListeners() {

        ok.addClickListener( event -> {
            Order order = dialogForm.getOrder();
            repo.save(order);
            close();
            Notify.success("Ваш заказ принят!");
        });

        ok.setText("Заказать!");

        deny.addClickListener(event -> {
            close();
        });
    }
}
