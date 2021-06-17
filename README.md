# Student-Attendance-System
Student Attendance System
## 项目简介
实现教师登陆注册，每个教师账户的课程管理、用户管理、学生管理和考勤管理的一个前后端分离项目。

前端运用了VUE框架配合elementUI开发网页页面，后端使用springboot、springMVC、Mybatis、redis的技术栈，使用分布式任务调度平台xxl-job完成定时任务的调用，使用JWT令牌实现账号的认证登陆，数据库使用mysql,，项目均使用docker部署在阿里云服务器的Linux系统上，代码使用git管理工具管理进行管理。后续使用springcloudalibaba和springcloud的组件对项目进行重构。

前端代码：https://github.com/1012926267/vue_cil

## 内置功能

1.  用户管理：管理的是教师个人信息和账号信息
2.  课程管理：管理课程列表的增删改查以及每个教师所拥有的课程和每个课程所包含的学生（学生选课和教师选课）
3.  学生管理：管理学生列表的增删改查
4.  考勤管理：管理学生的出勤状态，涉及硬件读取卡号更新学生状态
5.  日程管理：日历功能



## 演示图

登陆界面：

![login](https://github.com/1012926267/Student-Attendance-System/blob/master/Vue_Springboot/src/main/resources/static/demonstration/login.png)



注册界面：

![register](https://github.com/1012926267/Student-Attendance-System/blob/master/Vue_Springboot/src/main/resources/static/demonstration/register.png)



课程管理界面：

![index](https://github.com/1012926267/Student-Attendance-System/blob/master/Vue_Springboot/src/main/resources/static/demonstration/index.png)



![course](https://github.com/1012926267/Student-Attendance-System/blob/master/Vue_Springboot/src/main/resources/static/demonstration/course.png)



学生管理界面：

![student](https://github.com/1012926267/Student-Attendance-System/blob/master/Vue_Springboot/src/main/resources/static/demonstration/student.png)



用户管理界面：

![userinfo](https://github.com/1012926267/Student-Attendance-System/blob/master/Vue_Springboot/src/main/resources/static/demonstration/user%20info.png)



![userinfo2](https://github.com/1012926267/Student-Attendance-System/blob/master/Vue_Springboot/src/main/resources/static/demonstration/userinfo2.png)



日程管理界面：

![date](https://github.com/1012926267/Student-Attendance-System/blob/master/Vue_Springboot/src/main/resources/static/demonstration/date.png)


