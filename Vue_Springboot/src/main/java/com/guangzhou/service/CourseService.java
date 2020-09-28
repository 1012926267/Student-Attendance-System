package com.guangzhou.service;

import com.guangzhou.entity.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {
    /**
     *
     * @param course 岗位信息
     * @return  岗位列表
     */
    public List<Course> selectCourseList(Course course);

    /**
     * 添加课程
     * @param course 课程信息
     */
    public void addCourse(Course course);

    /**
     * 修改课程
     * @param course 课程信息
     */
    public void updateCourse(Course course);

    /**
     *
     * @param id 主键编号
     * @return 课程信息
     */
    public Course selectCourseById(Integer id);

    /**
     * 删除课程信息集合
     * @param ids 主键编号集合
     */
    public void deleteCourseByIds(Integer[] ids);

    /**
     * 查询用户的课程
     * @param username 用户名
     * @return  课程信息
     */
//    public List<Course> selectCoursesByTeacherId(String username);
//    public List<Course> selectCoursesByTeacherId(String username,String course_name);
    public List<Course> selectCoursesByTeacherId(String username,String course_name,String course_id);

    /**
     * 添加课程到用户
     * @param list 中间表集合
     */
    public void addCourseByTeacherUsername (List<Map<String, String>> list);

    /**
     * 移除用户课程
     * @param course_id 课程号
     * @param username 用户名
     */
    public void deleteCourseByUsername (String course_id ,String username);

    /**
     * 根据id搜索course_id
     * @param ids id集合
     * @return 课程id集合
     */
    public String[] selectCourse_idById (Integer[] ids);

    /**
     * 根据课程id删除中间表信息
     * @param courses_id 课程id
     */
    public void deleteCatByCourse_id (String[] courses_id);
}
