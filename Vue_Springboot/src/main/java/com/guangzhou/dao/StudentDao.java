package com.guangzhou.dao;



import com.guangzhou.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    /**
     * 查询课程
     * @param student 学生信息
     * @return 学生数据集合
     */
    public List<Student> selectStudentList(Student student);

    /**
     * 添加学生
     * @param student 学生信息
     */
    public void addStudent(Student student);

    /**
     * 修改学生
     * @param student 学生信息
     */
    public void updateStudent(Student student);

    /**
     * 根据序号返回学生信息
     * @param student_number 学生序号
     * @return  学生数据
     */
    public Student selectStudentByNumber(Integer student_number);

    /**
     * 删除学生数据
     * @param student_number 学生序号
     */
    public void deleteStudentByNumber(Integer student_number);

    /**
     * 批量删除学生数据
     * @param student_numbers 学生序号数组
     */
    public void deleteStudentByNumbers(Integer[] student_numbers);

    /**
     * 根据课程id搜索学生并可根据学生信息筛选
     * @param map 课程id和学生信息集合
     * @return 学生集合
     */
    public List<Student> selectStudentById(Map<String,Object> map);

    /**
     * 添加学生到课程
     * @param list 中间表集合
     */
    public void addStudentById(List<Map<String, String>> list);

    /**
     * 根据课程id删除学生
     * @param id 课程id
     * @param students_number 学生编号
     */
    public void deleteStudentById(@Param("id") String id ,@Param("students_number") Integer[] students_number);

    /**
     * 根据学生number删除中间表信息
     * @param students_number 学生号
     */
     void deleteCasByStudent_number(Integer[] students_number);
}
