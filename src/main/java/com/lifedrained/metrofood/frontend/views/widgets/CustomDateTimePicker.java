package com.lifedrained.metrofood.frontend.views.widgets;

import com.lifedrained.metrofood.frontend.i18n.RussianDate;
import com.lifedrained.metrofood.utils.Notify;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


public class CustomDateTimePicker extends DateTimePicker implements HasDateTime {
    public CustomDateTimePicker(String lbl){
        setLabel(lbl);

        setDatePickerI18n(new RussianDate());
        setStep(Duration.ofMinutes(5));
        setMin(LocalDateTime.now());
        setMax(LocalDateTime.now().plusMonths(24));
    }

    @Override
    public Date getDate(){
        if (getValue() == null){
            Notify.error("Выбрана некорректная дата!");
        }
        return Date.from(getValue().atZone(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public Time getTime(){
        return Time.valueOf(getValue().toLocalTime());
    }
}
