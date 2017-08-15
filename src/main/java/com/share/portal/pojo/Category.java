package com.share.portal.pojo;

import java.util.Date;

public class Category {
    private Integer id;

    private Integer parentId;

    private String name;

    private Date created;

    private Date updated;

    public Category(Integer id, Integer parentId, String name, Date created, Date updated) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.created = created;
        this.updated = updated;
    }

    public Category() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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