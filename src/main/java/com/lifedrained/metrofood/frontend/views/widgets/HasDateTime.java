package com.lifedrained.metrofood.frontend.views.widgets;

import java.sql.Time;
import java.util.Date;

public interface HasDateTime {
   default Date getDate(){
       return new Date();
   }
   default Time getTime(){
      return null;
   }
}
