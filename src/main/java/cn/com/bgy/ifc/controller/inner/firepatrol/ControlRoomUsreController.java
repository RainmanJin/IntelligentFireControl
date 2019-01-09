package cn.com.bgy.ifc.controller.inner.firepatrol;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.ControlRoomUserDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomUser;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/firepatrol/controlRoomUser")
public class ControlRoomUsreController extends BaseController {
    @Autowired
    private ControlRoomUserDomain controlRoomUserDomain;

    /**
     * @description:分页查询消防演练及宣传情况
     * @param: [page, controlRoomUser]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomUser>>
     * @auther: chenlie
     * @date: 2019/1/7 17:24
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo<ControlRoomUser>> queryListByPage(Page<ControlRoomUser> page, ControlRoomUser controlRoomUser) {

        PageInfo<ControlRoomUser> pageInfo = controlRoomUserDomain.queryListByPage(page, controlRoomUser);
        return ResponseVO.<PageInfo<ControlRoomUser>>success().setData(pageInfo);
    }
    /**
     * @description:根据id查询消防演练及宣传情况
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomUser>
     * @auther: chenlie
     * @date: 2019/1/8 10:44
     */
    @GetMapping("findById")
    public ResponseVO<ControlRoomUser> findById(Long id) {

        ControlRoomUser controlRoomUser= controlRoomUserDomain.findById(id);
        return ResponseVO.<ControlRoomUser>success().setData(controlRoomUser);
    }



    /**
     * @description:批量逻辑删除
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomUser>
     * @auther: chenlie
     * @date: 2019/1/8 10:44
     */
    @GetMapping("deleteData")
    public ResponseVO<Object> deleteData(String ids) {
        if(ids==null|| ids.isEmpty() ){
            return ResponseVO.error().setMsg("参数异常");
        }
        List<Long> list= ListUtil.getListId(ids);
        int res= controlRoomUserDomain.deleteBatch(list);
        if(res>0){
            return ResponseVO.success();
        } else{
            return ResponseVO.deleteError();
        }
    }

    /**
     * @description:修改
     * @param: [controlRoomUser]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @auther: chenlie
     * @date: 2019/1/8 11:28
     */
    @GetMapping("editData")
    public ResponseVO<Object> editData(ControlRoomUser controlRoomUser) {

        ControlRoomUser  query =controlRoomUserDomain.findById(controlRoomUser.getId());
        CopyUtil.copyProperties(controlRoomUser,query);
        int res= controlRoomUserDomain.update(query);
        if(res>0){
            return ResponseVO.success();
        } else{
            return ResponseVO.editError();
        }
    }


    /**
     * @description:新增
     * @param: [controlRoomUser]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @auther: chenlie
     * @date: 2019/1/8 11:28
     */
    @GetMapping("createData")
    public ResponseVO<Object> createData(ControlRoomUser controlRoomUser) {

        int res= controlRoomUserDomain.insert(controlRoomUser);
        if(res>0){
            return ResponseVO.success();
        } else{
            return ResponseVO.editError();
        }
    }
}
