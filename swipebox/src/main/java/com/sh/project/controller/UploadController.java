package com.sh.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.sh.project.service.FileStorageService;


@Controller
public class UploadController {
	
	@RequestMapping(value = "/link")
	public ModelAndView showLink(HttpSession session) {
		ModelAndView mav;
		if(session.getAttribute("s_id") == null) {
			mav = new ModelAndView("login");
		}else {
			mav = new ModelAndView("linkPage");
		}
		return mav;
	}
     
    @RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
    public String dragAndDrop(Model model) {
         
        return "fileUpload";
         
    }
     
    @RequestMapping(value = "/fileUpload/post", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView upload(MultipartHttpServletRequest multipartRequest, HttpSession session) { 
    		//
    		String userId = (String) session.getAttribute("s_id");
    		FileStorageService uploadservice = new FileStorageService(multipartRequest,userId);
    		System.out.println(multipartRequest.getFileNames());
    		uploadservice.uploadFiles();
          return new ModelAndView("list");
        //return "success";
    }
    
    @RequestMapping(value = "/fileUpload/directPost", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView directUpload(MultipartHttpServletRequest multipartRequest, HttpSession session) { 
    		//
    		ModelAndView mav = new ModelAndView();
    		mav.setViewName("redirect:/list");
    		String userId = (String) session.getAttribute("s_id");
    		FileStorageService uploadservice = new FileStorageService(multipartRequest,userId);
    		System.out.println(multipartRequest.getFileNames());
    		uploadservice.uploadFiles();
          return mav;
        //return "success";
    }
     
}
