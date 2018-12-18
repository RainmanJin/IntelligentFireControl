package cn.com.bgy.ifc.bgy.pager;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author huxin
 * @Date 2018/12/18 13:46
 * @Description 查询分页
 **/

public abstract class PageBase<T> {
    public PageInfo<T> queryListByPage( Page<T> page,List<T> list ){
        PageHelper.startPage(page.getPageNum(),page.getPageSize(),page.getOrderBy());
        return new PageInfo<T>(list);
    }
}
