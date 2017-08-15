package com.share.portal.pojo;

import java.util.Date;

public class TopicsComment {
    private Integer id;

    private String userId;

    private Integer topicsId;

    private Integer floor;

    private String content;

    private Integer replyFloor;

    private Byte isDelete;

    private Date created;

    private Date updated;

    public TopicsComment(Integer id, String userId, Integer topicsId, Integer floor, String content, Integer replyFloor, Byte isDelete, Date created, Date updated) {
        this.id = id;
        this.userId = userId;
        this.topicsId = topicsId;
        this.floor = floor;
        this.content = content;
        this.replyFloor = replyFloor;
        this.isDelete = isDelete;
        this.created = created;
        this.updated = updated;
    }

    public TopicsComment() {
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

    public Integer getReplyFloor() {
        return replyFloor;
    }

    public void setReplyFloor(Integer replyFloor) {
        this.replyFloor = replyFloor;
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