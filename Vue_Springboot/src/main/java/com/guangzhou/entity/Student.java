package com.guangzhou.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable {
    private String student_number;
    private String student_id;
    private String student_name;
    private String student_college;
    private String student_profession;
    private String student_sex;
    private String student_attendance;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_college() {
        return student_college;
    }

    public void setStudent_college(String student_college) {
        this.student_college = student_college;
    }

    public String getStudent_profession() {
        return student_profession;
    }

    public void setStudent_profession(String student_profession) {
        this.student_profession = student_profession;
    }

    public String getStudent_sex() {
        return student_sex;
    }

    public void setStudent_sex(String student_sex) {
        this.student_sex = student_sex;
    }

    public String getStudent_attendance() {
        return student_attendance;
    }

    public void setStudent_attendance(String student_attendance) {
        this.student_attendance = student_attendance;
    }
}
