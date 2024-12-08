package com.lifedrained.metrofood.frontend.views.dialogs;


import com.lifedrained.metrofood.frontend.views.widgets.CustomButton;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;

/**
 *
 * @param <T> - Возвращаемый тип данных в слушателе {@link OnConfirmDialogListener}
 *           , а также тип данных возвращаемый {@link #getDataFromFields()}
 */

public abstract class BaseDialog<T> extends Dialog {
    protected OnConfirmDialogListener<T> confirmListener;
    protected CustomButton ok,deny;

    public BaseDialog(OnConfirmDialogListener<T> confirmListener){
        this.confirmListener =  confirmListener;
        initBtns();
        setButtonListeners();
        setDraggable(true);
    }

    public abstract T getDataFromFields();
    protected abstract void setButtonListeners();
    private void initBtns(){
        ok = new CustomButton("Сохранить");
        deny = new CustomButton("Отмена");
        deny.setTheme(ButtonVariant.LUMO_ERROR);
        getFooter().add(deny,ok);
    }
}
