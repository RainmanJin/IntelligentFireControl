package cn.com.bgy.ifc.bgy.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2018-12-28 19:01
 **/
public class DBAgent {

    /**
     * 根据指定数据集合进行内存分页
     * pageNum 当前页
     * pageSize 每页记录数
     * total 总记录数
     * startRow 获取翻页起始加载记录位置
     * @param dataList 要进行分页的数据集合
     * @param pages 翻页信息对象
     * @return 内存数据翻页结果集
     */
    @SuppressWarnings("rawtypes")
    public static List memoryPaging(final List dataList, final Page pages) {
        int size = pages.getPageSize(), page = pages.getPageNum(), start = pages.getStartRow();
        List datas = dataList;
        while (start > datas.size()) {
            pages.setPageNum(--page);
            start = pages.getStartRow();
        }
        pages.setTotal(datas.size());
        long end = (start + size) > pages.getTotal() ? pages.getTotal() : (start + size);
        List<Object> resultList = new ArrayList<>();
        for (; start < end; start++) {
            resultList.add(datas.get(start));
        }
        return resultList;
    }

    /**
     *
     * @param info
     * @param pages
     * @return
     */
    public static PageInfo getPages(final PageInfo info,final Page pages) {
        int nowPage=pages.getPageNum();
        long recordCount=pages.getTotal();
        int pageSize=pages.getPageSize();
        // 总页数
        int pageCount = (int)recordCount % pageSize > 0 ? (int)recordCount / pageSize + 1 : (int)recordCount / pageSize;
        // 判断总页数是否小于当前页
        int newNowPage = pageCount < nowPage ? 1 : nowPage;
        // 开始记录数
        int startRecord = (newNowPage - 1) * pageSize;
        info.setTotal(recordCount);
        info.setPageSize(pageSize);
        info.setPageNum(nowPage);
        info.setPages(pageCount);
        info.setStartRow(startRecord);
        return info;
    }
}
