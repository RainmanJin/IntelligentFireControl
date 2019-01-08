package cn.com.bgy.ifc.bgy.utils;

import cn.com.bgy.ifc.entity.po.system.Department;
import cn.com.bgy.ifc.entity.vo.system.DepartmentVo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.*;

public class CopyUtil {

    /**
     * @author: ZhangCheng
     * @description:说明：Apache BeanUtils性能较差，所以改用性能好的Cglib BeanCopier
     * @param: [source, target]
     * @return: void
     */
    public static void copyProperties(Object source, Object target) {
        BeanCopier beanCopier = BeanCopier.create(source.getClass(),target.getClass(),false);
        beanCopier.copy(source, target, null);
    }

    /**
     * @author: ZhangCheng
     * @description:List<PO>转List<Vo>
     * @param: [list, dataObj]
     * @return: java.util.List
     */
    public static List convertList(final List list, final Object dataObj) {
        List<Object> resultList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String jsonStr = JSONObject.toJSONString(list.get(i));
            resultList.add(JSON.parseObject(jsonStr, dataObj.getClass()));
        }
        return resultList;
    }



}
