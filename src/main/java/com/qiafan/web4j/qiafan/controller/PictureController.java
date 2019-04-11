package com.qiafan.web4j.qiafan.controller;

import com.qiafan.web4j.qiafan.bean.msg.Msg;
import com.qiafan.web4j.qiafan.utils.FilePathHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by ZhangYao
 * Date 2019/4/10 Time 20:36
 */
@Controller
public class PictureController {
    @RequestMapping("uploadImage")
    @ResponseBody
    public Msg uploadImage(MultipartFile file, HttpServletRequest request) throws Exception {
        Msg msg = new Msg();
        if (file == null){
            msg.setMsg("没有上传文件");
            msg.setCode(1);
            return msg;
        }
        //String realPath = request.getServletContext().getRealPath("");
        String realPath = this.getClass().getClassLoader().getResource("").getPath();
        String fileName = file.getOriginalFilename();
        fileName = UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));
        char[] chars = Integer.toHexString(fileName.hashCode()).toCharArray();
        String relativePath= FilePathHelper.getRelativePathByFileName(fileName);
        File imgdirs = new File(realPath + "/static/images/"+relativePath);
        if (!imgdirs.exists()){
            imgdirs.mkdirs();
        }
        File img = new File(imgdirs,fileName);
        try {
            file.transferTo(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
        msg.setCode(0);
        msg.setMsg("/images/"+relativePath+fileName);
        return msg;
    }
}
