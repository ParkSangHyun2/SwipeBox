package com.sh.project.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sh.project.dao.UserFileDAO;
import com.sh.project.service.FileListService;
import com.sh.project.userfiles.DataManagementService;

@Controller
public class ListController {
	//
	private DataManagementService dbFileStore;
	
	public ListController() {
		try {
			dbFileStore = new DataManagementService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/list")
	public ModelAndView viewList(HttpSession session) {
		//
		String userId = (String) session.getAttribute("s_id");
		if(userId ==null) {
			return new ModelAndView("login");
		}
		FileListService fileListService = new FileListService();
		//ArrayList<PersonalFile> userList = (ArrayList<PersonalFile>) fileListService.getUserFileList();
		Collection<UserFileDAO> userList = null;
		try {
			userList = dbFileStore.selectAll(userId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userList.isEmpty()) {
			System.out.println("empty List");
		}else {
			//System.out.println("no empty" + userList.iterator().next().getFileName());
		}
		
		ModelAndView mav = new ModelAndView("fileList");
		mav.addObject("userList", userList);
		//mav.addObject("user",user);
		//model.addAttribute("list", list);
		return mav;
	}

}
