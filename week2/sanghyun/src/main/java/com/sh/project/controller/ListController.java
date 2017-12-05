package com.sh.project.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sh.project.dao.PersonalFile;
import com.sh.project.service.FileListService;

@Controller
public class ListController {

	@RequestMapping("/list")
	public ModelAndView viewList() {
		FileListService fileListService = new FileListService();
		ArrayList<PersonalFile> userList = (ArrayList<PersonalFile>) fileListService.getUserFileList();
		if(userList.isEmpty()) {
			System.out.println("empty List");
		}else {
			System.out.println("no empty" + userList.iterator().next().getFileName());
		}
		ModelAndView mav = new ModelAndView("fileList");
		mav.addObject("userList", userList);
		//model.addAttribute("list", list);
		return mav;
	}

}
