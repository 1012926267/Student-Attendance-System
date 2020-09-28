package com.guangzhou.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.guangzhou.entity.Teacher;
import com.guangzhou.service.TeacherService;
import com.guangzhou.utils.JWTUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    /**
     * 用户登陆
     * @param teacherDB 用户账号密码
     * @return 用户信息以及token认证
     */
    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody Teacher teacherDB){
        Map<String,Object> map = new HashMap<>();
        String username = teacherDB.getUsername();
        String password = teacherDB.getPassword();
//        System.out.println(username + password);
        try {
            Teacher teacher = teacherService.login(username,password);
            Map<String,String> payload = new HashMap<>();
            payload.put("username",teacher.getUsername());
            payload.put("name",teacher.getTeacher_name());
            String token = JWTUtils.getToken(payload);
            map.put("state",true);
            map.put("msg","认证成功");
            map.put("token",token);
        }catch (Exception e){
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        return map;
    }

    /**
     * 获取用户信息
     * @param username 用户名
     * @return 用户信息
     */
    @GetMapping("/getTeacherMessage")
    public  Map<String,Object> getTeacherMessage(@RequestParam("username") String username){
        Map<String,Object> map = new HashMap<>();
        try {
            Teacher teacher = teacherService.selectUserInfo(username);
            map.put("teacherMessage",teacher);
            map.put("success",true);
            map.put("msg","获取用户信息成功");
        } catch (Exception e) {
            map.put("success",false);
            map.put("msg","获取用户信息失败");
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 通过token获取用户名以及账号
     * @param token 令牌
     * @return 用户信息
     */
  @PostMapping("/getTeacher")
    public Map<String,Object> getTeacher(@RequestBody String token){
        Map<String,Object> map = new HashMap<>();
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!Q@W3e4r%T^Y")).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            System.out.println("用户名: " + decodedJWT.getClaim("username").asString());
            System.out.println("姓名: "+decodedJWT.getClaim("name").asString());
            String username = decodedJWT.getClaim("username").asString();
            String teacher_name = decodedJWT.getClaim("name").asString();
            Teacher teacher = teacherService.selectUserAvart(username);
            String teacher_url;
            if(exists(teacher.getTeacher_url())){
                teacher_url = teacher.getTeacher_url();
            }else {
                teacher_url = "https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png";
            }
            String idteacher = teacher.getIdteacher();
            map.put("state",true);
            map.put("msg","获取用户信息成功");
            map.put("username",username);
            map.put("name",teacher_name);
            map.put("idteacher",idteacher);
            map.put("avartUrl",teacher_url);
        }catch (Exception e){
            map.put("state",false);
            map.put("msg","获取用户信息失败" + e.getMessage());
        }
        return map;
    }



    /**
     * 上传用户头像
     * @param file 头像图片
     * @param username 用户名
     * @return 上传状态
     * @throws IOException 异常
     */
    @PostMapping("/avatar")
    public Map<String,Object> updateAvatar(@RequestParam("avatarfile") MultipartFile file,@RequestParam("username") String username) throws IOException
    {   Map<String,Object> map = new HashMap<>();
        if (!file.isEmpty())
        {
            try {
                String path = ResourceUtils.getURL("classpath:").getPath() + "static/avatar";
                File dir = new File(path);
                if(!dir.exists()){
                    dir.mkdirs();
                }
                String extension = FilenameUtils.getExtension(file.getOriginalFilename());
                String fileName = username + "." +extension;
                File filePicture = new File(dir, fileName);
                file.transferTo(filePicture);
                String teacher_url = "http://localhost:8081/attendance/avatar/" + fileName ;
                teacherService.updateAvatar(username,teacher_url);
                map.put("success",true);
                map.put("msg","修改用户头像信息成功");
                return map;
            } catch (IOException e) {
                e.printStackTrace();
                map.put("success",false);
                map.put("msg","修改用户头像信息失败" + e.getMessage());
                return map;
            }
        }
        else {
            return map;
        }
}


    /**
     * 用户注册
     * @param teacher 用户信息
     * @return 注册状态
     */
    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody Teacher teacher){
        Map<String,Object> map = new HashMap<>();
        System.out.println(teacher);
        try {
                teacherService.addTeacher(teacher);
                map.put("state",true);
                map.put("msg","注册成功");
        } catch (Exception e) {
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        return map ;
    }

    /**
     * 判断网站链接是否存在
     * @param URLName
     * @return 判断结果
     */
    public static boolean exists(String URLName) {
        try {
            //设置此类是否应该自动执行 HTTP 重定向（响应代码为 3xx 的请求）。
            HttpURLConnection.setFollowRedirects(false);
            //到 URL 所引用的远程对象的连接
            HttpURLConnection con = (HttpURLConnection) new URL(URLName)
                    .openConnection();
            /* 设置 URL 请求的方法， GET POST HEAD OPTIONS PUT DELETE TRACE 以上方法之一是合法的，具体取决于协议的限制。*/
            con.setRequestMethod("HEAD");
            //从 HTTP 响应消息获取状态码
            return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    /**
     * 更新用户信息
     * @param teacher 用户信息
     * @return 更新状态
     */
    @PostMapping("/updateTeacher")
    public Map<String, Object> update(@RequestBody Teacher teacher) {
/*        System.out.println("我进来了");
        System.out.println(teacher);*/
    HashMap<String, Object> map = new HashMap<>();
    try {
        teacherService.updateTeacher(teacher);
        map.put("success", true);
        map.put("msg", "更新用户信息成功");
    } catch (Exception e) {
        e.printStackTrace();
        map.put("success", false);
        map.put("msg", "更新用户信息失败: " + e.getMessage());
    }
    return map;
}

    /**
     * 更新密码
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @param username 用户名
     * @return 更新状态
     */
    @GetMapping("/updatePassword")
    public Map<String, Object> updatePassword(@RequestParam("oldPassword") String oldPassword ,@RequestParam("newPassword") String newPassword ,@RequestParam("userInfo_username") String username) {/*
        System.out.println("我进来了");
        System.out.println(teacher);*/
        HashMap<String, Object> map = new HashMap<>();
        try {
            String password = teacherService.confirmPassword(username);
            System.out.println(password);
            System.out.println(oldPassword);
            System.out.println(newPassword);
            if(Objects.equals(oldPassword, password)){
                teacherService.updatePassword(newPassword , username);
                map.put("state",true);
                map.put("success", true);
                map.put("msg", "修改密码成功");
            }else {
                map.put("state",true);
                map.put("success", false);
                map.put("msg", "修改密码失败，输入的旧密码错误");
            }

        } catch (Exception e) {
            map.put("state",false);
            e.printStackTrace();
            map.put("msg", "更新用户信息失败: " + e.getMessage());
        }
        return map;
    }
}
