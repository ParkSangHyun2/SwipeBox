package com.sh.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.project.dao.UserFileDAO;
import com.sh.project.service.FileStorageService;
import com.sh.project.userfiles.DataManagementService;

@Controller
public class StoreController {
	//
	private String filePath = "/Users/parksanghyun/files/";
	
	private FileStorageService fileStorageService;
	private DataManagementService dbFileStore;
	
	public StoreController() {
		try {
			dbFileStore = new DataManagementService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileStorageService = new FileStorageService();
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String downloadFile(HttpServletResponse response,
		HttpServletRequest request,
		HttpSession session,
		@RequestParam(value = "file",required=true) String fileUid) {
			
		String userId = (String) session.getAttribute("s_id");
		
		UserFileDAO foundFile = dbFileStore.selectByUid(fileUid);
		String fileName = foundFile.getFileName();
		dbFileStore.delete(userId, fileName);	
		fileStorageService.deleteFile(fileUid);
		
		
		return "redirect:list";
	}
}
