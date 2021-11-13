package com.group3.shoesshop.controller.common;

import com.group3.shoesshop.utils.MyUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileController {

    @GetMapping(value = "/file", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getFile(@RequestParam String name) {
        return MyUtils.getFileFromGoogleCloud(name);
    }

}
