package com.gem.web.admin.food;

import com.gem.config.AppConfig;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: linna
 * @Date: 2019/08/24 09:10
 * @Description: wangEditor上传类
 */
@RestController
@RequestMapping("/a/upload")
public class UploadController {
    @Autowired
    private AppConfig appConfig;

    @RequestMapping("/editor")
    @ResponseBody
    public Object editor(MultipartFile file) {
        String fileName ="";
        if(!file.isEmpty()){
            //返回的是字节长度,1M=1024k=1048576字节 也就是if(fileSize<5*1048576)
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

            fileName = System.currentTimeMillis()+suffix;
            String saveFileName = appConfig.getFilepath()+"/images/"+fileName;
            File dest = new File(saveFileName);
            if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
                dest.getParentFile().mkdir();
            }
            try {
                file.transferTo(dest); //保存文件
            } catch (Exception e) {
                e.printStackTrace();
                return new WangEditorResponse("1","上传失败"+e.getMessage());
            }
        }else {
            return new WangEditorResponse("1","上传出错");
        }
        String imgUrl=appConfig.getUrlpath()+"article/"+fileName;
        String img = fileName;
        List<String> data = new ArrayList<>();
        data.add(imgUrl);
        data.add(img);
        return new WangEditorResponse("0",data );
    }

    @Data
    private class WangEditorResponse{
        String errno;
        List<String> data;
        public WangEditorResponse(String errno,List<String> data){
            this.errno=errno;
            this.data=data;
        }
        public WangEditorResponse(String errno,String data){
            this.errno=errno;
            this.data=new ArrayList<>();
            this.data.add(data);
        }
    }

}
