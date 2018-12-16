package cn.com.bgy.ifc.entity.po.basic;

public class SystemRole {

    private Long id;
    /**
     *角色类型
     */
    private Integer type;
    /**
     *角色类型
     */
    private String typeName;

    private String name;

    private Integer state;

    private Long organizationId;

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
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName( String typeName ) {
        this.typeName = typeName;
    }
}