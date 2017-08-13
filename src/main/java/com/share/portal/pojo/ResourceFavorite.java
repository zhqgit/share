package com.share.portal.pojo;

import java.util.Date;

public class ResourceFavorite {
    private Integer id;

    private String userId;

    private Integer resourceId;

    private Integer personalResourceCategoryId;

    private Date created;

    private Date updated;

    public ResourceFavorite(Integer id, String userId, Integer resourceId, Integer personalResourceCategoryId, Date created, Date updated) {
        this.id = id;
        this.userId = userId;
        this.resourceId = resourceId;
        this.personalResourceCategoryId = personalResourceCategoryId;
        this.created = created;
        this.updated = updated;
    }

    public ResourceFavorite() {
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

    public Integer getPersonalResourceCategoryId() {
        return personalResourceCategoryId;
    }

    public void setPersonalResourceCategoryId(Integer personalResourceCategoryId) {
        this.personalResourceCategoryId = personalResourceCategoryId;
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