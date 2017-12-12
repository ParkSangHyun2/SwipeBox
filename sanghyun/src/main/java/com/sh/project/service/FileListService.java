package com.sh.project.service;

import java.io.File;
import java.util.List;

import com.sh.project.vo.PersonalFile;
import com.sh.project.vo.UserFiles;

public class FileListService {
	//
	private final String path = "/Users/parksanghyun/csv";
	private File dirFile;
	private File[] userFileList;
	
	private PersonalFile personalFile;
	private UserFiles userFiles;
	
	public FileListService() {
		dirFile = new File(path);
		userFiles = new UserFiles();
		userFileList = dirFile.listFiles();
	}

	public List<PersonalFile> getUserFileList(){
		//
		int pos;
		String type;
		
		for(File file : userFileList) {
			pos = file.getName().lastIndexOf(".");
			String fileName = file.getName().substring(0, pos);
			
			personalFile = new PersonalFile();
			personalFile.setFullFileName(file.getName());
			personalFile.setFileName(fileName);
			personalFile.setFileSize(setSizeFormat(file.length()));
			
			type = file.getName().substring(pos + 1);
			personalFile.setFileType(type);
			
			userFiles.addFile(personalFile);
		}
		return userFiles.list();
	}
	
	private String setSizeFormat(long fileSize) {
		//
		if(fileSize > 1024 && fileSize < 1048576) {
			long toKB = fileSize/1024;
			return Long.toString(toKB) + " KB";
		}else if(fileSize >= 1048576) {
			long toMB = fileSize/1024/1024;
			return Long.toString(toMB) + " MB";
		}else {
			return fileSize + " Byte";
		}
	}
}
