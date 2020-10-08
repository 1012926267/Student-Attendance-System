package com.guangzhou.springboot_vue;

import com.guangzhou.dao.TeacherDao;
import com.guangzhou.entity.Course;
import com.guangzhou.entity.Student;
import com.guangzhou.entity.Teacher;
import com.guangzhou.service.CourseService;
import com.guangzhou.service.StudentService;
import com.guangzhou.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootVueApplicationTests {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testAddTeacher (){
        Teacher teacherTest = new Teacher();
        teacherTest.setPassword("33690728a");
        teacherTest.setTeacher_name("千手间猪");
        teacherTest.setUsername("13929561728");
        teacherTest.setInvite("3369");
        teacherTest.setTeacher_sex("男");
        teacherService.addTeacher(teacherTest);
    }

    @Test
    public void testSelectCourse_id (){
        Integer[] ids = {1,2,3};
        String[] strings = courseService.selectCourse_idById(ids);
        System.out.println(ids);
        System.out.println(strings.clone());
    }

    @Test
    public void testDeleteCourse_id (){
        String[] courses_id = {"1710"};
        courseService.deleteCatByCourse_id(courses_id);

    }

    @Test
    public void testDeleteStudent_number (){
        Integer[] student_number = {2};
        studentService.deleteCasByStudent_number(student_number);

    }


    @Test
    public void testGetTeacherMessage (){
        String username = "1012926267";
        Teacher teacher = teacherService.selectUserInfo(username);
        System.out.println(teacher);
    }

    @Test
    public void testPostCourseList (){
        Course course = new Course();
        course.setCourse_id("1703");
        List<Course> courses = courseService.selectCourseList(course);
        System.out.println(courses);

    }

    @Test
    public void testAddCourse (){
        Course course = new Course();
        course.setCourse_id("1709");
        course.setCourse_name("AJ购买指南");
        courseService.addCourse(course);

    }

    @Test
    public void testAddStudent (){
        Student student = new Student();
        student.setStudent_id("17114090606");
        student.setStudent_name("高乖巧");
        student.setStudent_college("艾欧尼亚");
        student.setStudent_profession("辅助皮肤选用技术");
        student.setStudent_sex("男");
        student.setStudent_attendance("2016");
        studentService.addStudent(student);

    }

    @Test
    public void testSelectStudentByNumber (){
        Integer student_number = 1;
        Student student = studentService.selectStudentByNumber(student_number);
        System.out.println(student);
        Student students = studentService.selectStudentByNumber(student_number);
    }

    @Test
    public void testUpdateStudent (){
        Integer student_number = 1;
        Student student = studentService.selectStudentByNumber(student_number);
        System.out.println(student);

    }

    @Test
    public void testSelectCourseById (){
        Integer id = 1;
        Course course = courseService.selectCourseById(id);
        System.out.println(course);

    }

    @Test
    public void testupdateCourseById (){
        Integer id = 1;
        Course course = courseService.selectCourseById(id);
        System.out.println(course);

    }

/*    @Test
    public void testSelectCoursesByTeacherId (){
        String username = "1012926267";
        List<Course> courses = courseService.selectCoursesByTeacherId(username);
        System.out.println(courses);
    }*/

    @Test
    public void testSelectCoursesByTeacherId (){
        String username = "1012926267";
        String course_name = "";
        String course_id = "1701";
        List<Course> courses = courseService.selectCoursesByTeacherId(username,course_name,course_id);
        System.out.println(courses);
    }

    @Test
    public void testAddCourseByTeacherUsername (){
        List<String> courses_id = new LinkedList<>();
        List<Map<String, String>> courseList = new LinkedList<>();
        courses_id.add("1709");
        String username = "1012926267";
        for (String course_id: courses_id
        ) {
            Map<String, String> maps = new HashMap<>();
            maps.put("course_id",course_id);
            maps.put("username",username);
            courseList.add(maps);
        }
        courseService.addCourseByTeacherUsername(courseList);

    }

    @Test
    public void testUpdateTeacher (){
        Teacher teacher = new Teacher();
        teacher.setTelephone("13570313369");
        teacher.setMail("13570313369@qq.com");
        teacher.setIdteacher("7");
        teacherService.updateTeacher(teacher);
    }

    @Test
    public void testUpdatePassword(){
        String username = "18011779517";
        String newPassword = "33690728a";
        teacherService.updatePassword(newPassword,username);
    }

    @Test
    public void testSelectStudentById(){
        String id = "1";
/*        String student_number = "1";*/
        Student student = new Student();
        student.setStudent_name("吴战犯");
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("student_number",student.getStudent_number());
        map.put("student_name",student.getStudent_name());
        map.put("student_attendance",student.getStudent_attendance());
        List<Student> students = studentService.selectStudentById(map);
        System.out.println(students);
    }

    @Test
    public void testDeleteStudentById(){
        String id = "2";
        Integer[] students_number = {1,2};
        studentService.deleteStudentById(id,students_number);
    }

    @Test
    public void testDeleteCourseByUsername(){
        String course_id = "1701";
        String username = "1842039717";
        courseService.deleteCourseByUsername(course_id,username);
    }
}
