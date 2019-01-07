package cn.com.bgy.ifc.bgy.utils;

import cn.com.bgy.ifc.entity.vo.system.DepartmentVo;

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
     * @description:转换treeList
     * @param: [list, parentId]
     * @return: java.util.List<cn.com.bgy.ifc.entity.vo.basic.DepartmentVo>
     */
    public static List<DepartmentVo> switchTree(List<DepartmentVo> list, Long parentId){
        List<DepartmentVo> treeList = new ArrayList<DepartmentVo>();
        int size=list.size();
        for(int i=0;i<size;i++){
            DepartmentVo vo=list.get(i);
            // 根据传入的某个父节点ID,遍历该父节点的所有子节点
            if(vo.getParentId().equals(parentId)){
                recursionFn(list, vo);
                treeList.add(vo);
            }
        }
        return treeList;
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
            if (n.getParentId().equals(t.getId())) {
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
