package cn.com.bgy.ifc.domain.impl.project;

import cn.com.bgy.ifc.dao.project.ModelPowerDao;
import cn.com.bgy.ifc.domain.interfaces.system.ModelPowerDomain;
import cn.com.bgy.ifc.entity.po.basic.*;
import cn.com.bgy.ifc.entity.po.system.ModelPower;
import cn.com.bgy.ifc.entity.po.system.SystemModel;
import cn.com.bgy.ifc.entity.po.system.SystemPower;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ModelPowerDomainImpl implements ModelPowerDomain {

    @Resource
    ModelPowerDao modelPowerDao;

    @Override
    public PageInfo<ModelPower> queryPageList(Page page, ModelPower modelPower) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<ModelPower> modelPowerList = modelPowerDao.queryPageList(modelPower);
        PageInfo<ModelPower> pageInfo = new PageInfo<>(modelPowerList);
        return pageInfo;
    }

    @Override
    public int insert(ModelPower modelPower) {
        return modelPowerDao.insert( modelPower);
    }

    @Override
    public List<String> getModelName() {
        List<String> list = modelPowerDao.getModelName();
        System.out.println(null==list);
        System.out.println(list.size());
        return list;
    }

    @Override
    public int saveModelPower(ModelPower modelPower) {
        //保存权限
        SystemPower systemPower = new SystemPower();
        systemPower.setLogicRemove(false);
        systemPower.setDisplayName(modelPower.getDisplayName());
        systemPower.setName(modelPower.getPowerName());
        systemPower.setRemark(modelPower.getRemark());
        int pint = modelPowerDao.insertSystemPower(systemPower);
        //查询模块对象
        SystemModel systemModel = modelPowerDao.querySystemModelbyName(modelPower.getModelName());
        //保存menu
        SystemMenu systemMenu = new SystemMenu();
        systemMenu.setName(modelPower.getModelName());
        systemMenu.setLogicRemove(false);
        systemMenu.setPowerId(systemPower.getId());
        systemMenu.setImageUrl(systemModel.getIconName());
        systemMenu.setNavigateUrl(systemModel.getUrlValue());
        systemMenu.setSortIndex(1);
//        systemMenu.setParentId();
        int mint = modelPowerDao.insertSystemMenu(systemMenu);
        if(pint!=0&&mint!=0){
            return 1;
        }
        return 0;
    }

    @Override
    public void deleteModelPower(Long[] longs) {
        modelPowerDao.deletePower(longs);
        modelPowerDao.deleteMenu(longs);
    }

    @Override
    public void deleteModelPowerOne(Long id) {
        modelPowerDao.deletePowerOne(id);
        modelPowerDao.deleteMenuOne(id);
    }
}
