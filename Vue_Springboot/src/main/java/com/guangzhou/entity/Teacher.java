package com.guangzhou.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teacher implements Serializable {
    private String idteacher;
    private String username;
    private String password;
    private String teacher_name;
    private String invite;
    private String teacher_sex;
    private String telephone;
    private String mail;
    private String teacher_url;

    public String getTeacher_url() {
        return teacher_url;
    }

    public void setTeacher_url(String teacher_url) {
        this.teacher_url = teacher_url;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTeacher_sex() {
        return teacher_sex;
    }

    public void setTeacher_sex(String teacher_sex) {
        this.teacher_sex = teacher_sex;
    }

    public String getInvite() {
        return invite;
    }

    public void setInvite(String invite) {
        this.invite = invite;
    }

    public String getIdteacher() {
        return idteacher;
    }

    public void setIdteacher(String idteacher) {
        this.idteacher = idteacher;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }
}
