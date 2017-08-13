package com.share.portal.pojo;

import java.util.Date;

public class ResourceComment {
    private Integer id;

    private String userId;

    private Integer resourceId;

    private Integer floor;

    private String content;

    private Byte isDelete;

    private Date created;

    private Date updated;

    public ResourceComment(Integer id, String userId, Integer resourceId, Integer floor, String content, Byte isDelete, Date created, Date updated) {
        this.id = id;
        this.userId = userId;
        this.resourceId = resourceId;
        this.floor = floor;
        this.content = content;
        this.isDelete = isDelete;
        this.created = created;
        this.updated = updated;
    }

    public ResourceComment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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