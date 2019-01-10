package cn.com.bgy.ifc.bgy.utils;

import cn.com.bgy.ifc.entity.vo.common.SelectVo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:枚举工具类
 * @date: 2019-01-10 17:47
 **/
public class EnumUtil {

    /**
     * @author: ZhangCheng
     * @description:封装枚举List对象
     * @param: [cls]
     * @return: java.util.List<cn.com.bgy.ifc.entity.vo.common.SelectVo>
     */
    public static List<SelectVo> getSelectList(Class<?> cls){
        List<SelectVo> list = new ArrayList<>();
        try {
            // 获取所有枚举常量
            Object[] objects = cls.getEnumConstants();
            // 调用对应方法，得到枚举常量中字段的值
            Method getValue = cls.getMethod("getValue");
            Method getName = cls.getMethod("getName");
            for (Object obj : objects) {
                SelectVo selectVo = new SelectVo();
                selectVo.setValue(getValue.invoke(obj).toString());
                selectVo.setName(getName.invoke(obj).toString());
                list.add(selectVo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
