package com.sh.project.service;

import java.io.File;
import java.util.Iterator;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileStorageService {
	//
	private MultipartHttpServletRequest multipartRequest;
	private Iterator<String> itr;

	private final String filePath = "/Users/parksanghyun/csv";// 디렉터리 수정해야

	public FileStorageService(MultipartHttpServletRequest multipartRequest) {
		this.multipartRequest = multipartRequest;
		this.itr = multipartRequest.getFileNames();
	}

	public void uploadFiles() {
		while (itr.hasNext()) {
			MultipartFile mpf = multipartRequest.getFile(itr.next());

			String originalFilename = mpf.getOriginalFilename();

			String fileFullPath = filePath + "/" + originalFilename;

			try {
				mpf.transferTo(new File(fileFullPath)); // service

			} catch (Exception e) {
				System.out.println("ERROR" + fileFullPath);
				e.printStackTrace();
			}
		}
	}
	
	public void downloadFile() {
		//
	}
}
