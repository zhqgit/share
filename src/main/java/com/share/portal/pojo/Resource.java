package com.share.portal.pojo;

import java.util.Date;

public class Resource {
    private Integer id;

    private String name;

    private Integer categoryId;

    private Double size;

    private String description;

    private Integer userId;

    private Integer personalCategoryId;

    private Integer pageview;

    private Integer downloadCount;

    private Byte type;

    private String resourceAddress;

    private Byte isDelete;

    private Date created;

    private Date updated;

    public Resource(Integer id, String name, Integer categoryId, Double size, String description, Integer userId, Integer personalCategoryId, Integer pageview, Integer downloadCount, Byte type, String resourceAddress, Byte isDelete, Date created, Date updated) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.size = size;
        this.description = description;
        this.userId = userId;
        this.personalCategoryId = personalCategoryId;
        this.pageview = pageview;
        this.downloadCount = downloadCount;
        this.type = type;
        this.resourceAddress = resourceAddress;
        this.isDelete = isDelete;
        this.created = created;
        this.updated = updated;
    }

    public Resource() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPersonalCategoryId() {
        return personalCategoryId;
    }

    public void setPersonalCategoryId(Integer personalCategoryId) {
        this.personalCategoryId = personalCategoryId;
    }

    public Integer getPageview() {
        return pageview;
    }

    public void setPageview(Integer pageview) {
        this.pageview = pageview;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getResourceAddress() {
        return resourceAddress;
    }

    public void setResourceAddress(String resourceAddress) {
        this.resourceAddress = resourceAddress == null ? null : resourceAddress.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}