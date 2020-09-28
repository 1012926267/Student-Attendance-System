package com.guangzhou.service;

import com.guangzhou.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherService {
    /**
     * 用户登陆
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    Teacher login (String username , String password);

    /**
     * 用户注册
     * @param teacher 用户信息
     */
    void addTeacher( Teacher teacher);

    /**
     * 查询用户基本资料
     * @param username 账号
     * @return 用户基本资料
     */
    public Teacher selectUserInfo (String username);

    /**
     * 更新用户基本信息
     * @param teacher
     */
    public void updateTeacher (Teacher teacher);

    /**
     * 确认密码
     * @param username 账号
     * @return 返回密码
     */
    public String confirmPassword (String username);

    /**
     * 修改密码
     * @param newPassword 新密码
     * @param username 用户账号
     */
    public void updatePassword (String newPassword , String username);

    /**
     * 返回用户的id和url信息
     * @param username 用户名
     * @return 用户对象信息
     */
    public Teacher selectUserAvart (String username);

    /**
     * 修改头像地址
     * @param username 用户名
     * @param teacher_url 用户头像地址
     */
    public void updateAvatar(String username,String teacher_url);

}
