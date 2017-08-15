package com.share.portal.pojo;

import java.util.Date;

public class Topics {
    private Integer id;

    private String title;

    private String content;

    private Integer categoryId;

    private Integer userId;

    private String personalCategoryId;

    private Byte isDelete;

    private Date created;

    private Date updated;

    public Topics(Integer id, String title, String content, Integer categoryId, Integer userId, String personalCategoryId, Byte isDelete, Date created, Date updated) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
        this.userId = userId;
        this.personalCategoryId = personalCategoryId;
        this.isDelete = isDelete;
        this.created = created;
        this.updated = updated;
    }

    public Topics() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPersonalCategoryId() {
        return personalCategoryId;
    }

    public void setPersonalCategoryId(String personalCategoryId) {
        this.personalCategoryId = personalCategoryId == null ? null : personalCategoryId.trim();
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