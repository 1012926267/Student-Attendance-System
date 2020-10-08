package com.guangzhou.service.imp;

import com.guangzhou.dao.StudentDao;
import com.guangzhou.entity.Student;
import com.guangzhou.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    /**
     * 查询学生信息集合
     * @param student 学生信息
     * @return 学生数据集合
     */
    @Override
    public List<Student> selectStudentList(Student student) {
        return studentDao.selectStudentList(student);
    }

    /**
     * 添加学生
     * @param student 学生信息
     */
    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    /**
     * 修改学生
     * @param student 学生信息
     */
    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    /**
     * 通过学生序号查询学生信息
     * @param student_number 学生序号
     * @return 学生信息
     */
    @Override
/*
//注解开启缓存
 @Cacheable("studentList")
 */
    public Student selectStudentByNumber(Integer student_number) {
        return studentDao.selectStudentByNumber(student_number);
    }

    /**
     * 通过学生序号删除学生信息
     * @param student_number 学生序号
     */
    @Override
    public void deleteStudentByNumber(Integer student_number) {
        studentDao.deleteStudentByNumber(student_number);
    }


    /**
     * 通过学生序号数组删除学生信息组
     * @param student_numbers 学生序号数组
     */
    @Override
    public void deleteStudentByNumbers(Integer[] student_numbers) {
        studentDao.deleteStudentByNumbers(student_numbers);
    }

    /**
     * 根据课程id搜索学生并可根据学生信息筛选
     * @param map 课程id和学生信息集合
     * @return 学生信息集合
     */
    @Override
    public List<Student> selectStudentById(Map<String, Object> map) {
        return studentDao.selectStudentById(map);
    }

    /**
     * 添加学生到课程
     * @param list 中间表集合
     */
    @Override
    public void addStudentById(List<Map<String, String>> list) {
        studentDao.addStudentById(list);
    }

    /**
     * 根据课程id删除学生
     * @param id 课程id
     * @param students_number 学生编号
     */
    @Override
    public void deleteStudentById(String id, Integer[] students_number) {
        studentDao.deleteStudentById(id,students_number);
    }

    /**
     * 根据学生number删除中间表信息
     * @param students_number 学生号
     */
    @Override
    public void deleteCasByStudent_number(Integer[] students_number) {
        studentDao.deleteCasByStudent_number(students_number);
    }

}
