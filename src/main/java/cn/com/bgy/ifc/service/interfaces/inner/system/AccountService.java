package cn.com.bgy.ifc.service.interfaces.inner.system;

import cn.com.bgy.ifc.entity.vo.common.SelectVo;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-19 19:52
 **/
public interface AccountService{

    List<SelectVo> queryListByRole(String roleValue, Long orgId);
}
