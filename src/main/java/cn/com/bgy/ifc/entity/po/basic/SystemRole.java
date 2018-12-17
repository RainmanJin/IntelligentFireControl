package cn.com.bgy.ifc.entity.po.basic;

public class SystemRole {

    private Long id;
    /**
     *角色类型
     */
    private Integer type;
    /**
     *角色类型名字（不存入数据库）
     */
    private String typename;
    /*
     * @Author huxin
     * @Description 角色名
     * @Date 2018/12/17 17:19
     */
    private String name;
    /**
     * @Author huxin
     * @Description 角色状态 0禁用 1 启用
     * @Date 2018/12/17 17:19
     */
    private Integer state;
    /**
     * @Author huxin
     * @Description  集成平台ID
     * @Date 2018/12/17 17:20
     */
    private Long organizationId;
    /**
     * @Author huxin
     * @Description 是否删除  true未删除  false以删除
     * @Date 2018/12/17 18:19
     */
    private Boolean logicRemove;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType( Integer type ) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Integer getState() {
        return state;
    }

    public void setState( Integer state ) {
        this.state = state;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId( Long organizationId ) {
        this.organizationId = organizationId;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove( Boolean logicRemove ) {
        this.logicRemove = logicRemove;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename( String typename ) {
        this.typename = typename;
    }
}