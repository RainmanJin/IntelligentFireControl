package cn.com.bgy.ifc.entity.po.system;

import java.util.Date;

public class SystemFile {
    /**
     * 编号
     */
    private Long id;

    /**
     * 文件来源编号
     */
    private Long receiveId;

    /**
     * 文件类别
     */
    private Byte fileSort;

    /**
     * 上传人编号
     */
    private Long authorId;

    /**
     * 上传人姓名
     */
    private String authorName;

    /**
     * 上传时间
     */
    private Date createTime;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件随机名
     */
    private String randomName;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件大小
     */
    private String fileSize;

    /**
     * 编号
     * @return id 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 编号
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 文件来源编号
     * @return receive_id 文件来源编号
     */
    public Long getReceiveId() {
        return receiveId;
    }

    /**
     * 文件来源编号
     * @param receiveId 文件来源编号
     */
    public void setReceiveId(Long receiveId) {
        this.receiveId = receiveId;
    }

    /**
     * 文件类别
     * @return file_sort 文件类别
     */
    public Byte getFileSort() {
        return fileSort;
    }

    /**
     * 文件类别
     * @param fileSort 文件类别
     */
    public void setFileSort(Byte fileSort) {
        this.fileSort = fileSort;
    }

    /**
     * 上传人编号
     * @return author_id 上传人编号
     */
    public Long getAuthorId() {
        return authorId;
    }

    /**
     * 上传人编号
     * @param authorId 上传人编号
     */
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    /**
     * 上传人姓名
     * @return author_name 上传人姓名
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * 上传人姓名
     * @param authorName 上传人姓名
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * 上传时间
     * @return create_time 上传时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 上传时间
     * @param createTime 上传时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 文件名
     * @return file_name 文件名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 文件名
     * @param fileName 文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 文件随机名
     * @return random_name 文件随机名
     */
    public String getRandomName() {
        return randomName;
    }

    /**
     * 文件随机名
     * @param randomName 文件随机名
     */
    public void setRandomName(String randomName) {
        this.randomName = randomName;
    }

    /**
     * 文件类型
     * @return file_type 文件类型
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 文件类型
     * @param fileType 文件类型
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * 文件大小
     * @return file_size 文件大小
     */
    public String getFileSize() {
        return fileSize;
    }

    /**
     * 文件大小
     * @param fileSize 文件大小
     */
    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }
}