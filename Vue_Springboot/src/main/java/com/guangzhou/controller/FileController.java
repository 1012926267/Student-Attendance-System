package com.guangzhou.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileController {

    /**
     * 课程图片上传
     * @param jpg 图片数据
     * @param course 课程信息
     * @return 上传状态
     * @throws IOException 抛出异常
     */
    @PostMapping("/lessonPicture")
    public Map<String,Object> upload (@RequestParam("file") MultipartFile jpg ,@RequestParam Map<String,String> course) throws IOException {
        String course_id = course.get("course_id");
        System.out.println(course_id);
        HashMap<String,Object> map = new HashMap<>();
        try {
            String path = ResourceUtils.getURL("classpath:").getPath() + "static/lesson";
            File dir = new File(path);
            if(!dir.exists()){
                dir.mkdirs();
            }
            String extension = FilenameUtils.getExtension(jpg.getOriginalFilename());
            String fileName = course_id + "." + extension;
            File filePicture = new File(dir, fileName);
            System.out.println(filePicture.getAbsolutePath());
            jpg.transferTo(new File(dir,fileName));
            map.put("pictureSuccess",true);
            map.put("pictureMsg","图片上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            map.put("pictureSuccess",false);
            map.put("pictureMsg","图片上传失败");
        }
        return map;
    }
}
