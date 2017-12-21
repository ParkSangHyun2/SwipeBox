package com.sh.project.service;

import java.io.File;
import java.util.Iterator;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sh.project.dao.UserFileDAO;
import com.sh.project.userfiles.DataManagementService;

public class FileStorageService {
	//
	private MultipartHttpServletRequest multipartRequest;
	private Iterator<String> itr;
	private DataManagementService dbFileStore;
	private String userId;

	private final String filePath = "/Users/nulgrace/files";// 디렉터리 수정해야
	
	public FileStorageService() {}

	public FileStorageService(MultipartHttpServletRequest multipartRequest, String userId) {
		this.multipartRequest = multipartRequest;
		this.itr = multipartRequest.getFileNames();
		this.userId = userId;
		try {
			dbFileStore = new DataManagementService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void uploadFiles() {
		while (itr.hasNext()) {
			MultipartFile mpf = multipartRequest.getFile(itr.next());
			String originalFilename = mpf.getOriginalFilename();
			int pos = originalFilename.lastIndexOf(".");
			String tempName = originalFilename.substring(0, pos);
			String fileName = originalFilename.substring(0, pos);
			String fileUid = Long.toString(System.currentTimeMillis());

			UserFileDAO userFile;
			int i = 1;
			while (true) {
				if ((userFile = dbFileStore.select(userId, fileName)) != null) {
					fileName = tempName +"("+i+")";
					if ((userFile =dbFileStore.select(userId, fileName))!=null) {
						i++;
						System.out.println("if " + fileName);
						fileName = tempName + "(" + i + ")";
						
					}else {
						break;
					}
				}else {
					break;
				}
			}

			userFile = new UserFileDAO(fileUid, userId, fileName, setSizeFormat(mpf.getSize()),
					originalFilename.substring(pos + 1));

			dbFileStore.insert(userFile);

			String fileFullPath = filePath + "/" + fileUid;

			try {
				mpf.transferTo(new File(fileFullPath)); // service

			} catch (Exception e) {
				System.out.println("ERROR" + fileFullPath);
				e.printStackTrace();
			}
		}
	}

	public void deleteFile(String fileUid) {
		//
		File deleteFile = new File(filePath + "/" + fileUid);
		deleteFile.delete();
	}

	private String setSizeFormat(long fileSize) {
		//
		if (fileSize > 1024 && fileSize < 1048576) {
			long toKB = fileSize / 1024;
			return Long.toString(toKB) + " KB";
		} else if (fileSize >= 1048576) {
			long toMB = fileSize / 1024 / 1024;
			return Long.toString(toMB) + " MB";
		} else {
			return fileSize + " Byte";
		}
	}
}
