package com.share.portal.pojo;

import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String userNumber;

    private Byte role;

    private String email;

    private Short grade;

    private String major;

    private String avatar;

    private Date created;

    private Date updated;
    public User(Integer id, String username, String password, String userNumber, Byte role, String email, Short grade, String major, String avatar, Date created, Date updated) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userNumber = userNumber;
        this.role = role;
        this.email = email;
        this.grade = grade;
        this.major = major;
        this.avatar = avatar;
        this.created = created;
        this.updated = updated;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber == null ? null : userNumber.trim();
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Short getGrade() {
        return grade;
    }

    public void setGrade(Short grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
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