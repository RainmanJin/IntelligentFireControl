package cn.com.bgy.ifc.entity.po.system;

import cn.com.bgy.ifc.entity.po.project.Project;
import cn.com.bgy.ifc.entity.po.project.RegionInfo;

import java.util.List;

public class Groups {
    private Long id;

    private String name;

    private Integer type;


    private Boolean logicRemove;

    private Long regionId;

    private String keyWords;

    private List<RegionInfo> listRegionInfo;

    private List<Project> listProject;

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public List<RegionInfo> getListRegionInfo() {
        return listRegionInfo;
    }

    public void setListRegionInfo(List<RegionInfo> listRegionInfo) {
        this.listRegionInfo = listRegionInfo;
    }

    public List<Project> getListProject() {
        return listProject;
    }

    public void setListProject(List<Project> listProject) {
        this.listProject = listProject;
    }
}