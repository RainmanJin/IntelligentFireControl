package cn.com.bgy.ifc.entity.po.projects;

/**
 * @Author huxin
 * @Date 2018/12/17 9:29
 * @Description 查询条件实体
 **/

public class QueryBena {
    //类型
    private Integer type;
    //关键字
    private String keyword;

    public Integer getType() {
        return type;
    }

    public void setType( Integer type ) {
        this.type = type;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword( String keyword ) {
        this.keyword = keyword;
    }
}
