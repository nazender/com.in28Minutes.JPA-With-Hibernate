package com.bugzzilla.test.controller;

import com.bugzzilla.test.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UploadController {

    private final UploadService uploadService;

    @Autowired
    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @RequestMapping(value = {"/upload"}, method = RequestMethod.POST)
    public String handleUpload(@RequestParam MultipartFile file, ModelMap modelMap) {

        if (!file.isEmpty()) {

            uploadService.parseCSV(file);

            return "upload";
        } else {
            modelMap.addAttribute("uploadError", "Payload required");
            return "upload";
        }
    }
}
