package cn.com.bgy.ifc.controller.inner.common;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {

    @InitBinder
    protected void initBinder(WebDataBinder binder){

        binder.registerCustomEditor(Date.class,new MyDateEditor());

    }

    private class MyDateEditor extends PropertyEditorSupport{
          public SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          @Override
          public void setAsText(String text) throws IllegalArgumentException{

              Date date = null;
              try {
                  date = format.parse(text);
              } catch (ParseException e) {
                  format = new SimpleDateFormat("yyyy-MM-dd");
                  try {
                      date = format.parse(text);
                  } catch (ParseException e1) {
                  }
              }
              setValue(date);
          }

          @Override
          public String getAsText(){
              return format.format(getValue());
          }



    }
}
