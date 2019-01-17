package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.Analog;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author: ZhangCheng
 * @description:模拟量管理
 * @date: 2019-01-15 16:29
 **/
public interface AnalogService {
    /**
     * 设备模拟量分页查询
     *
     * @param page
     * @param analog
     * @return
     */
    PageInfo<Analog> queryListByPage(Page page, Analog analog);

    /**
     * 模拟量ID查询
     *
     * @param id
     * @return
     */
    Analog findById(Long id);

    /**
     * 监听数据，添加模拟量
     *
     * @param jsonObject
     * @return
     */
    int insertAnalog(JSONObject jsonObject);

    /**
     * 设备模拟量编辑
     *
     * @param analog
     * @return
     */
    ResponseVO<Object> createAnalog(Analog analog);

    /**
     * 设备模拟量编辑
     *
     * @param analog
     * @return
     */
    ResponseVO<Object> editAnalog(Analog analog);

    /**
     * 设备模拟量重新同步
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseVO<Object> synchroAnalog(int pageNum, int pageSize);

    /**
     * 设备模拟量删除
     *
     * @param ids
     * @return
     */
    ResponseVO<Object> deleteAnalog(String ids);
}
