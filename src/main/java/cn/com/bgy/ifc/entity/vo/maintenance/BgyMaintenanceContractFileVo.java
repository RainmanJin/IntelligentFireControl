package cn.com.bgy.ifc.entity.vo.maintenance;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台维保合同文件VO
 * @date: 2018-12-24 10:28
 **/
public class BgyMaintenanceContractFileVo {

    private Long id;
    /**
     * 文件名
     */
    private String name;
    /**
     * 文件访问地址
     */
    private String url;
    /**
     * 创建时间
     */
    private String createTime;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
