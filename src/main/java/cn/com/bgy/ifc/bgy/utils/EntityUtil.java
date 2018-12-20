package cn.com.bgy.ifc.bgy.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: ZhangCheng
 * @description:实体bean工具类
 * @date: 2018-12-18 20:20
 **/
public class EntityUtil {

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * @author: ZhangCheng
     * @description:object转map
     * @param: [object]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    public static Map<String, Object> entityToMap(Object object)throws Exception  {
        Map<String, Object> valueMap = new HashMap<>();
        // 获取实体类的所有属性，返回Field数组
        Field[] field = EntityUtil.getAllFieldsList(object.getClass());
        // 获取length 提取相同操作
        int fieldLen = field.length;
        // 遍历所有属性
        for (int i = 0; i < fieldLen; i++) {
            // 获取属性的名字
            String name = field[i].getName();
            // 将属性的首字符大写，方便构造get，set方法
            String oName = name.substring(0, 1).toUpperCase() + name.substring(1);
            Method method = object.getClass().getMethod("get" + oName);
            Object value = method.invoke(object);
            if (value != null) {
                valueMap.put(humpToLine(name), value);
            }
        }
        return valueMap;
    }

    /**
     * @author: ZhangCheng
     * @description:驼峰命名转下划线
     * @param: [str]
     * @return: java.lang.String
     */
    public static String humpToLine(String name) {
        Matcher matcher = humpPattern.matcher(name);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 通过class.getDeclaredFields()获取所有的属性，
     * 然后再获取类的父类，再获取所有属性，直到父类为null截止
     * @param cls
     * @return
     */
    public static Field[] getAllFieldsList(final Class<?> cls) {
        final List<Field> allFields = new ArrayList<Field>();
        Class<?> currentClass = cls;
        while (currentClass != null) {
            final Field[] declaredFields = currentClass.getDeclaredFields();
            for (final Field field : declaredFields) {
                allFields.add(field);
            }
            currentClass = currentClass.getSuperclass();
        }
        return allFields.toArray(new Field[allFields.size()]);
    }
}
