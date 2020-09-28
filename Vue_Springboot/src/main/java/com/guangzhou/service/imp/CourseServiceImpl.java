package com.guangzhou.service.imp;

import com.guangzhou.dao.CourseDao;
import com.guangzhou.entity.Course;
import com.guangzhou.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class CourseServiceImpl implements CourseService {

    //导入dao层方法
    @Autowired
    private CourseDao courseDao;

    /**
     * 查询课程信息集合
     * @param course 课程信息
     * @return 课程列表
     */
    @Override
    public List<Course> selectCourseList(Course course) {
        return courseDao.selectCourseList(course);
    }

    /**
     * 添加课程
     * @param course 课程信息
     */
    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    /**
     * 修改课程
     * @param course 课程信息
     */
    @Override
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    /**
     * 根据主键编号返回课程信息
     * @param id 主键编号
     * @return 课程信息
     */
    @Override
    public Course selectCourseById(Integer id) {
        return courseDao.selectCourseById(id);
    }

    /**
     * 删除课程
     * @param ids 主键编号集合
     */
    @Override
    public void deleteCourseByIds(Integer[] ids) {
       courseDao.deleteCourseByIds(ids);
    }

    /**
     * 通过用户名搜索课程
     * @param username 用户名
     * @param course_name
     * @param course_id
     * @return
     */
    @Override
    public List<Course> selectCoursesByTeacherId(String username, String course_name, String course_id) {
        return courseDao.selectCoursesByTeacherId(username,course_name,course_id);
    }

    /**
     * 添加课程到用户
     * @param list 中间表集合
     */
    @Override
    public void addCourseByTeacherUsername(List<Map<String, String>> list) {
        courseDao.addCourseByTeacherUsername(list);
    }

    /**
     * 移除用户课程
     * @param course_id 课程号
     * @param username 用户名
     */
    @Override
    public void deleteCourseByUsername(String course_id, String username) {
        courseDao.deleteCourseByUsername(course_id,username);
    }

    @Override
    public String[] selectCourse_idById(Integer[] ids) {
        return courseDao.selectCourse_idById(ids);
    }

    @Override
    public void deleteCatByCourse_id(String[] courses_id) {
        courseDao.deleteCatByCourse_id(courses_id);
    }




/*    @Override
    public List<Course> selectCoursesByTeacherId(String username, String course_name) {
        return courseDao.selectCoursesByTeacherId(username,course_name);
    }*/

    /*    @Override
*//*    public List<Course> selectCoursesByTeacherId(String username) {
        return courseDao.selectCoursesByTeacherId(username);
    }*//*
    public List<Course> selectCoursesByTeacherId(String username,String course_name) {
        return courseDao.selectCoursesByTeacherId(username,course_name);
    }*/

}
