package com.share.portal.pojo;

import java.util.Date;

public class TopicsFavorite {
    private Integer id;

    private String userId;

    private Integer topicsId;

    private Integer personalTopicsCategoryId;

    private Date created;

    private Date updated;

    public TopicsFavorite(Integer id, String userId, Integer topicsId, Integer personalTopicsCategoryId, Date created, Date updated) {
        this.id = id;
        this.userId = userId;
        this.topicsId = topicsId;
        this.personalTopicsCategoryId = personalTopicsCategoryId;
        this.created = created;
        this.updated = updated;
    }

    public TopicsFavorite() {
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

    public Integer getTopicsId() {
        return topicsId;
    }

    public void setTopicsId(Integer topicsId) {
        this.topicsId = topicsId;
    }

    public Integer getPersonalTopicsCategoryId() {
        return personalTopicsCategoryId;
    }

    public void setPersonalTopicsCategoryId(Integer personalTopicsCategoryId) {
        this.personalTopicsCategoryId = personalTopicsCategoryId;
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