package com.guangzhou.controller;

import com.guangzhou.entity.Student;
import com.guangzhou.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;


    /**
     * 查询课程集合
     * @param student 学生信息
     * @return 学生列表
     */
   @PostMapping("/selectStudentList")
   public Map<String,Object> selectStudentList(@RequestBody Student student){
       System.out.println(student);
       HashMap<String,Object> map = new HashMap<>();
       try {
           List<Student> students = studentService.selectStudentList(student);
           map.put("success",true);
           map.put("msg","学生信息查询成功");
           map.put("studentsList",students);
       } catch (Exception e) {
           e.printStackTrace();
           map.put("success",false);
           map.put("msg","学生信息查询失败" + e.getMessage());
       }
       return map;
   }


    /**
     * 通过学生编号查询学生信息
     * @param student_number 学生编号
     * @return 学生信息
     */
    @GetMapping("/selectStudentByNumber")
    public Map<String,Object> selectStudentByNumber(@RequestParam("student_number") Integer student_number){
        System.out.println(student_number);
        HashMap<String,Object> map = new HashMap<>();
        try {
            Student student = studentService.selectStudentByNumber(student_number);
            map.put("success",true);
            map.put("msg","学生信息返回成功");
            map.put("student",student);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","学生信息返回失败" + e.getMessage());
        }
        return map;
    }

    /**
     * 通过课程id查询学生列表并可根据学生信息搜索
     * @param id 课程id
     * @param student_id 学生id
     * @param student_name 学生名
     * @param student_college 学院名
     * @param student_attendance 入学时间
     * @param student_profession 专业名
     * @param student_sex 性别
     * @return 学生列表
     */
    @GetMapping("/selectStudentById")
    public Map<String,Object> selectStudentById(@RequestParam("id") Integer id ,@RequestParam(value = "student_id",required = false) String student_id ,@RequestParam(value = "student_name",required = false) String student_name ,@RequestParam(value = "student_college",required = false) String student_college ,@RequestParam(value = "student_attendance",required = false) String student_attendance ,@RequestParam(value = "student_profession",required = false) String student_profession ,@RequestParam(value = "student_sex",required = false) String student_sex ){
        System.out.println(id);
        HashMap<String,Object> map = new HashMap<>();
        HashMap<String,Object> maps = new HashMap<>();
        try {
            maps.put("id",id);
            maps.put("student_id",student_id);
            maps.put("student_name",student_name);
            maps.put("student_attendance",student_attendance);
            maps.put("student_profession",student_profession);
            maps.put("student_sex",student_sex);
            maps.put("student_college",student_college);
            List<Student> students = studentService.selectStudentById(maps);
            map.put("studentList",students);
            map.put("success",true);
            map.put("msg","学生信息返回成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","学生信息返回失败" + e.getMessage());
        }
        return map;
    }

    /**
     * 添加学生
     * @param student 学生信息
     * @return 添加状态
     */
   @PostMapping("/addStudent")
   public Map<String, Object> testAdd(@RequestBody Student student){

       HashMap<String, Object> map = new HashMap<>();
       try {
           studentService.addStudent(student);
           map.put("success",true);
           map.put("msg","添加学生信息成功");
       } catch (Exception e) {
           e.printStackTrace();
           map.put("success",false);
           map.put("msg","添加学生信息失败" + e.getMessage());
       }
       return map;
   }

    /**
     * 更新学生
     * @param student 学生信息
     * @return 更新状态
     */
    @PostMapping("/updateStudent")
    public Map<String, Object> update(@RequestBody Student student) {
    /*    System.out.println("我进来了");
        System.out.println(student);*/
        HashMap<String, Object> map = new HashMap<>();
        try {
            studentService.updateStudent(student);
            map.put("success", true);
            map.put("msg", "更新学生信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("msg", "更新学生信息失败: " + e.getMessage());
        }
        return map;
    }

    /**
     * 删除学生
     * @param student_numbers 学生编号
     * @return 删除状态
     */
    @DeleteMapping ("/{student_numbers}")
    public Map<String,Object> deleteStudentByNumbers( @PathVariable Integer[] student_numbers) {
        System.out.println("我进来了");
        System.out.println(Arrays.toString(student_numbers));
        HashMap<String,Object> map = new HashMap<>();
        try {
            studentService.deleteCasByStudent_number(student_numbers);
            studentService.deleteStudentByNumbers(student_numbers);
            map.put("success",true);
            map.put("msg","删除学生信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","删除学生信息失败：" + e.getMessage() );
        }
        return map;
    }

    /**
     * 从课程里删除学生集合
     * @param id 课程id
     * @param students_number 学生编号
     * @return 删除状态
     */
    @GetMapping("/deleteStudentById")
    public Map<String,Object> deleteStudentById(@RequestParam("id") String id,@RequestParam("students_number") Integer[] students_number){
        HashMap<String, Object> map = new HashMap<>();
        try {
            studentService.deleteStudentById(id,students_number);
            map.put("success",true);
            map.put("msg","删除学生信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","删除学生信息失败：" + e.getMessage() );
        }
        return map;
    }

    /**
     * 批量添加学生到课程
     * @param id 课程id
     * @param students_number 学生编号
     * @return 添加状态
     */
    @GetMapping("/addStudentById")
    public Map<String,Object> addStudentById (@RequestParam("id") String id , @RequestParam("students_number") List<String> students_number ){
        System.out.println("我进来了");
        System.out.println("id为" + id);
        System.out.println("student_number为" + students_number);
        Map<String, Object> map = new HashMap<>();
        //定义要插入数据的map集合
        List<Map<String, String>> studentList = new LinkedList<>();
        try {
            for (String student_number : students_number
            ) {
                Map<String, String> maps = new HashMap<>();
                maps.put("id",id);
                maps.put("student_number",student_number);
                studentList.add(maps);
            }
            studentService.addStudentById(studentList);
            map.put("success",true);
            map.put("msg","添加学生信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","添加学生信息失败" + e.getMessage());
        }
        return map;
    }



}
