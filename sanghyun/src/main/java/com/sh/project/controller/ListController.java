package com.sh.project.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sh.project.service.FileListService;
import com.sh.project.vo.PersonalFile;

@Controller
public class ListController {

	@RequestMapping("/list")
	public ModelAndView viewList(HttpSession session) {
		//
		
		FileListService fileListService = new FileListService();
		ArrayList<PersonalFile> userList = (ArrayList<PersonalFile>) fileListService.getUserFileList();
		if(userList.isEmpty()) {
			System.out.println("empty List");
		}else {
			System.out.println("no empty" + userList.iterator().next().getFileName());
		}
		
		ModelAndView mav = new ModelAndView("fileList");
		mav.addObject("userList", userList);
		//mav.addObject("user",user);
		//model.addAttribute("list", list);
		return mav;
	}

}
