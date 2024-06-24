package com.api.controller;

import com.api.common.utils.PathUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@CrossOrigin
public class FileController {

    /**
     * 图片获取
     * @param imgName
     * @param response
     * @throws IOException
     */
    @GetMapping("/image")
    public void getImg(@RequestParam("imgName") String imgName, HttpServletResponse response) throws IOException {
        File fileDir = new File(PathUtils.getClassLoadRootPath() + "/pic");
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
}
