package com.group3.shoesshop.controller.common;

import com.group3.shoesshop.utils.MyUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ResourceBundle;

@Controller
public class FileController {

    @GetMapping(value = "/file", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getFile(@RequestParam String name) throws IOException {
        ResourceBundle rb = ResourceBundle.getBundle("google_cloud");
        File f = new File(rb.getString("downloaded.path") + "/" + name);
        if(f.exists() && !f.isDirectory()) {
            return Files.readAllBytes(f.toPath());
        }

        return MyUtils.getFileFromGoogleCloud(name);
    }

}
