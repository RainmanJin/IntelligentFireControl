package cn.com.bgy.ifc.service.interfaces.inner.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.FacilityProtection;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/7 18:55
 * @Description 消防设施保护情况
 **/

public interface FacilityProtectionService {

    int addFacilityProtection( FacilityProtection facilityProtection );

    int deleteFacilityProtection( String ids );

    int updateFacilityProtection( FacilityProtection facilityProtection );

    PageInfo listFacilityProtection( Page<Object> page, String keyword, Long recordId,Integer state);

    Map<String,Object> getFacilityProtectionFindById( Long id );


}
