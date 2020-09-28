package com.guangzhou.service.imp;

import com.guangzhou.dao.TeacherDao;
import com.guangzhou.entity.Teacher;
import com.guangzhou.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    /**
     * 用户登陆
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    @Override
    public Teacher login(String username, String password) {
        return teacherDao.findUsernameAndPassword(username,password);
    }


    /**
     * 用户注册
     * @param teacher 用户信息
     */
    @Override
    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
    }

    /**
     * 搜索用户基本信息
     * @param username 账号
     * @return 用户基本信息
     */
    @Override
    public Teacher selectUserInfo(String username) {
        return teacherDao.selectUserInfo(username);
    }

    /**
     * 更新用户信息
     * @param teacher
     */
    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
    }

    /**
     * 确认密码
     * @param username 账号
     * @return 返回密码
     */
    @Override
    public String confirmPassword(String username) {
        return teacherDao.confirmPassword(username);
    }

    /**
     * 修改密码
     * @param newPassword 新密码
     * @param username 用户账号
     */
    @Override
    public void updatePassword(String newPassword, String username) {
        teacherDao.updatePassword(newPassword , username);
    }

    /**
     * 返回返回用户的id和url信息
     * @param username 用户名
     * @return 用户对象信息
     */
    @Override
    public Teacher selectUserAvart(String username) {
        return teacherDao.selectUserAvart(username);
    }

    /**
     * 修改头像地址
     * @param username 用户名
     * @param teacher_url 用户头像地址
     */
    @Override
    public void updateAvatar(String username, String teacher_url) {
        teacherDao.updateAvatar(username ,teacher_url);
    }


}
