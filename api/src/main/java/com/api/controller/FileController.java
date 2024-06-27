package com.api.controller;

import com.api.common.enums.ErrorMsg;
import com.api.model.vo.ResultVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@CrossOrigin
@RestController
public class FileController {

    @Value("${file.upload-path}")
    private String uploadPath;

    /**
     * 图片获取
     * @param imgName
     * @param response
     * @throws IOException
     */
    @GetMapping("/image")
    public void getImg(@RequestParam("imageName") String imgName, HttpServletResponse response) throws IOException {
        File fileDir = new File(uploadPath + "/images");
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
    public ResultVo uploadFile(@RequestParam("file") MultipartFile file) {
        File fileDir = new File(uploadPath + "/" +"images");
        if (!fileDir.exists()){
            fileDir.mkdirs();
        }
        File image = new File(fileDir.getAbsolutePath()+"/"+file.getOriginalFilename());
        try {
            file.transferTo(image);
            return ResultVo.success("/image?imageName=" + file.getOriginalFilename());
        }catch (IOException e){
            e.printStackTrace();
            return ResultVo.fail(ErrorMsg.UPLOAD_FAIL);
        }
    }
}
