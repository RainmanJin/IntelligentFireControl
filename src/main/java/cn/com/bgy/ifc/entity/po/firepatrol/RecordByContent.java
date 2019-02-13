package cn.com.bgy.ifc.entity.po.firepatrol;

public class RecordByContent implements Serializable{
    /**
     * ID
     */
    private Long id;

    /**
     * 记录表ID
     */
    private Long recordId;

    /**
     * 记录内容表ID
     */
    private Long contentId;

    /**
     * ID
     * @return id ID
     */
    public Long getId() {
        return id;
    }

    /**
     * ID
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 记录表ID
     * @return record_id 记录表ID
     */
    public Long getRecordId() {
        return recordId;
    }

    /**
     * 记录表ID
     * @param recordId 记录表ID
     */
    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    /**
     * 记录内容表ID
     * @return content_id 记录内容表ID
     */
    public Long getContentId() {
        return contentId;
    }

    /**
     * 记录内容表ID
     * @param contentId 记录内容表ID
     */
    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }
}