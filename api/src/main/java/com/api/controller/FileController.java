package com.api.controller;

import com.api.common.utils.PathUtils;
import com.api.model.vo.ResultVo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@CrossOrigin
@RestController
public class FileController {

    /**
     * 图片获取
     * @param imgName
     * @param response
     * @throws IOException
     */
    @GetMapping("/image")
    public void getImg(@RequestParam("imageName") String imgName, HttpServletResponse response) throws IOException {
        File fileDir = new File(PathUtils.getClassLoadRootPath() + "/images");
        File image = new File(fileDir.getAbsolutePath()+"/"+imgName);
        if (image.exists()){
            FileInputStream fileInputStream = new FileInputStream(image);
            byte[] bytes=new byte[fileInputStream.available()];
            if (fileInputStream.read(bytes)>0){
                OutputStream outputStream = response.getOutputStream();
                outputStream.write(bytes);
                outputStream.close();
            }
            fileInputStream.close();
        }
    }

    @PostMapping("/file")
    public ResultVo uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        File fileDir = new File(PathUtils.getClassLoadRootPath() + "/images");
        if (!fileDir.exists()){
            fileDir.mkdirs();
        }
        File image = new File(fileDir.getAbsolutePath()+"/"+file.getOriginalFilename());
        file.transferTo(image);
        return ResultVo.success( "/image?imageName="+file.getOriginalFilename());
    }
}
