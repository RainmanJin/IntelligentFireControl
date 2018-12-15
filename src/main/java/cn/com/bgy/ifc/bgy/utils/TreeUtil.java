package cn.com.bgy.ifc.bgy.utils;

import cn.com.bgy.ifc.entity.vo.basic.DepartmentVo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:树形结构工具类
 * @date: 2018-12-14 17:04
 **/
public class TreeUtil {

    /**
     * @author: ZhangCheng
     * @description:
     * @param: [list, parentId]
     * @return: java.util.List<cn.com.bgy.ifc.entity.vo.basic.DepartmentVo>
     */
    public static List<DepartmentVo> getChildEntity(List<DepartmentVo> list, Long parentId) {
        List<DepartmentVo> functionList = new ArrayList<DepartmentVo>();
        for (Iterator<DepartmentVo> iterator = list.iterator(); iterator.hasNext(); ) {
            DepartmentVo t = iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (t.getParentId() == parentId) {
                recursionFn(list, t);
                functionList.add(t);
            }
        }
        return functionList;
    }

    /**
     * 递归列表
     *
     * @param list
     * @param t
     */
    public static void recursionFn(List<DepartmentVo> list, DepartmentVo t) {
        // 得到子节点列表
        List<DepartmentVo> childList = getChildList(list, t);
        t.setChildren(childList);
        for (DepartmentVo tChild : childList) {
            // 判断是否有子节点
            if (hasChild(list, tChild)) {
                Iterator<DepartmentVo> it = childList.iterator();
                while (it.hasNext()) {
                    DepartmentVo n = (DepartmentVo) it.next();
                    recursionFn(list, n);
                }
            }
        }
    }

    /**
     * 获取子节点列表
     *
     * @param list
     * @param t
     * @return
     */
    public static List<DepartmentVo> getChildList(List<DepartmentVo> list, DepartmentVo t) {
        List<DepartmentVo> tList = new ArrayList<DepartmentVo>();
        Iterator<DepartmentVo> it = list.iterator();
        while (it.hasNext()) {
            DepartmentVo n = (DepartmentVo) it.next();
            if (n.getParentId() == t.getId()) {
                tList.add(n);
            }
        }
        return tList;
    }

    /**
     * 判断是否有子节点
     *
     * @param list
     * @param t
     * @return
     */
    public static boolean hasChild(List<DepartmentVo> list, DepartmentVo t) {
        // 判断size>0则返回 true 否则返回false
        return getChildList(list, t).size() > 0 ? true : false;
    }
}
