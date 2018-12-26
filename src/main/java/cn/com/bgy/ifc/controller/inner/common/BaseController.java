package cn.com.bgy.ifc.controller.inner.common;

import cn.com.bgy.ifc.entity.po.system.Account;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {

    Logger logger= LoggerFactory.getLogger(BaseController.class);

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
                      logger.error("日期格式化异常：",e1);
                  }
              }
              setValue(date);
          }

          @Override
          public String getAsText(){
              return format.format(getValue());
          }



    }

    /**
     * 获取登录用户信息
     * @return
     */ public Account getUser(){
        Account user= (Account) SecurityUtils.getSubject().getSession().getAttribute("user");
        return user;
     }

}
