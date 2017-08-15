package com.share.portal.pojo;

import java.util.Date;

public class ResourceReport {
    private Integer id;

    private String type;

    private String description;

    private String reporteUser;

    private String beReportedUser;

    private Date created;

    private Date updated;

    private String resourceCommentId;

    public ResourceReport(Integer id, String type, String description, String reporteUser, String beReportedUser, Date created, Date updated, String resourceCommentId) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.reporteUser = reporteUser;
        this.beReportedUser = beReportedUser;
        this.created = created;
        this.updated = updated;
        this.resourceCommentId = resourceCommentId;
    }

    public ResourceReport() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getReporteUser() {
        return reporteUser;
    }

    public void setReporteUser(String reporteUser) {
        this.reporteUser = reporteUser == null ? null : reporteUser.trim();
    }

    public String getBeReportedUser() {
        return beReportedUser;
    }

    public void setBeReportedUser(String beReportedUser) {
        this.beReportedUser = beReportedUser == null ? null : beReportedUser.trim();
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

    public String getResourceCommentId() {
        return resourceCommentId;
    }

    public void setResourceCommentId(String resourceCommentId) {
        this.resourceCommentId = resourceCommentId == null ? null : resourceCommentId.trim();
    }
}