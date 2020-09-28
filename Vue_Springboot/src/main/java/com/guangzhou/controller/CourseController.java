package com.guangzhou.controller;


import com.guangzhou.entity.Course;
import com.guangzhou.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 查询课程集合
     * @param course 课程信息
     * @return 课程信息
     */
    @PostMapping("/selectList")
    public Map<String,Object> selectCourseList(@RequestBody Course course){
        System.out.println(course);
        HashMap<String,Object> map = new HashMap<>();
        try {
        List<Course> courses = courseService.selectCourseList(course);

            map.put("success",true);
            map.put("msg","课程信息查询成功");
            map.put("coursesList",courses);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","课程信息查询失败" + e.getMessage());
        }
        return map;
    }

    /**
     * 添加课程
     * @param course 课程信息
     * @return 添加状态
     */
    @PostMapping("/addCourse")
    public Map<String,Object> testFrom(@RequestBody Course course){
        HashMap<String,Object> map = new HashMap<>();;
        try {
            courseService.addCourse(course);
            map.put("success",true);
            map.put("msg","课程信息查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","课程信息查询失败" + e.getMessage());

        }
        return map;
    }

    /**
     * 更新课程
     * @param course 课程信息
     * @return 更新状态
     */
    @PostMapping("/updateCourse")
    public Map<String, Object> update(@RequestBody Course course) {
        System.out.println("我进来了");
        System.out.println(course);
        HashMap<String, Object> map = new HashMap<>();
        try {
            courseService.updateCourse(course);
            map.put("success", true);
            map.put("msg", "更新课程信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("msg", "更新课程信息失败: " + e.getMessage());
        }
        return map;
    }

    /**
     * 通过课程id搜索课程信息
     * @param id 课程id
     * @return 课程信息
     */
    @GetMapping("/selectCourseById")
    public Map<String,Object> selectCourseById(@RequestParam("id") Integer id){
        System.out.println(id);
        HashMap<String,Object> map = new HashMap<>();
        try {
            Course course = courseService.selectCourseById(id);
            map.put("success",true);
            map.put("msg","课程信息返回成功");
            map.put("course",course);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","课程信息返回失败" + e.getMessage());
        }
        return map;
    }

    /**
     * 批量删除课程信息
     * @param ids 课程id集合
     * @return 删除状态
     */
    @DeleteMapping ("/{ids}")
    public Map<String,Object> deleteCourseByIds( @PathVariable Integer[] ids) {
        System.out.println("我进来了");
        HashMap<String,Object> map = new HashMap<>();
        try {
            String[] courses_id = courseService.selectCourse_idById(ids);
            courseService.deleteCatByCourse_id(courses_id);
            courseService.deleteCourseByIds(ids);
            map.put("success",true);
            map.put("msg","删除课程信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","删除课程信息失败：" + e.getMessage() );
        }
        return map;
    }

    /**
     * 通过用户账号搜索课程
     * @param username 用户账号
     * @param course_name 课程名
     * @param course_id 课程编号
     * @return 课程列表
     */
    @GetMapping("/selectCoursesByTeacherId")
    public Map<String,Object> selectCoursesByTeacherId (@RequestParam("username") String username,@RequestParam(value = "course_name",required = false) String course_name,@RequestParam(value = "course_id",required = false) String course_id){
/*    System.out.println("w" + username);
    System.out.println("s" + course_name);
    System.out.println("x" + course_id);*/
    HashMap<String, Object> map = new HashMap<>();
    try {
        List<Course> courses = courseService.selectCoursesByTeacherId(username,course_name,course_id);
        map.put("courseList",courses);
        map.put("success",true);
        map.put("msg","查询课程信息成功");
    } catch (Exception e) {
        e.printStackTrace();
        map.put("success",false);
        map.put("msg","查询课程信息失败：" + e.getMessage() );
    }
    return map;

}

    /**
     * 通过课程编号以及用户账号添加中间表数据
     * @param courses_id 课程编号
     * @param username 用户账号
     * @return 添加状态
     */
    @GetMapping("/addCourseByTeacherUsername")
    public Map<String,Object> addCourseByTeacherUsername (@RequestParam("courses_id") List<String> courses_id , @RequestParam("username") String username ){
        System.out.println("我进来了");
        Map<String, Object> map = new HashMap<>();
        //定义要插入数据的map集合
        List<Map<String, String>> courseList = new LinkedList<>();
        try {
            for (String course_id: courses_id
                 ) {
                Map<String, String> maps = new HashMap<>();
                maps.put("course_id",course_id);
                maps.put("username",username);
                courseList.add(maps);
            }
            courseService.addCourseByTeacherUsername(courseList);
            map.put("success",true);
            map.put("msg","添加课程信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","添加课程信息失败");
        }
        return map;
    }

    /**
     * 通过课程删除中间表数据
     * @param course_id 课程编号
     * @param username 用户账号
     * @return 删除状态
     */
    @GetMapping("deleteCourseByTeacherUsername")
    public Map<String,Object> deleteCourseByTeacherUsername (@RequestParam("course_id") String course_id ,@RequestParam("username") String username){
        HashMap<String, Object> map = new HashMap<>();
        try {
            courseService.deleteCourseByUsername(course_id,username);
            map.put("success",true);
            map.put("msg","移除课程信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","移除课程信息失败：" + e.getMessage() );
        }
        return map;
    }


}
