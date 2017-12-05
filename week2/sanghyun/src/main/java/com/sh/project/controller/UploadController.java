package com.sh.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sh.project.service.FileStorageService;


@Controller
public class UploadController {
     
    @RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
    public String dragAndDrop(Model model) {
         
        return "fileUpload";
         
    }
     
    @RequestMapping(value = "/fileUpload/post", method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartHttpServletRequest multipartRequest) { 
    		//
    		FileStorageService uploadservice = new FileStorageService(multipartRequest);
    		uploadservice.uploadFiles();
          return "fileUpload";
        //return "success";
    }
     
}
