package com.sh.project.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.project.dao.UserFileDAO;
import com.sh.project.userfiles.DataManagementService;

@Controller
public class DownloadController {
	//
	private String filePath = "/Users/nulgrace/files/";
	private String fileName = "test999.txt";
	
	private DataManagementService dbFileStore;
	private OutputStream outs = null;
	private FileInputStream fis = null;
	
	public DownloadController() {
		try {
			dbFileStore = new DataManagementService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String downloadFile(HttpServletResponse response,
		HttpServletRequest request,
			@RequestParam(value = "file",required=true) String fileUid) {
		    UserFileDAO foundUserFile = dbFileStore.selectByUid(fileUid);
			String fullFileName = foundUserFile.getFileName()+"."+foundUserFile.getFileType();
					
			//fileUid = foundUserFile.getFileUid();
			System.out.println("in servlet" + fileUid);
			
			File tempFile = new File(filePath + fullFileName);
			try {
				tempFile.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			File originalFile = new File(filePath + fileUid);
			tempFile.delete();
			originalFile.renameTo(tempFile);
			
		try {
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.setHeader("Content-Disposition", "attachment;fileName=\"" + fullFileName + "\";");
			outs = response.getOutputStream();

			try {
				fis = new FileInputStream(filePath + fullFileName);
				//fis = new File(fullFileName);
				int ch;
				while ((ch = fis.read()) != -1) {
					outs.write(ch);
				}
				outs.close();
				fis.close();
				outs.flush();
				

			} catch (IOException e) {
				response.setContentLength(0);
				System.out.println("File not found.");
				e.printStackTrace();
			} finally {
				if (outs != null) {
					outs.close();
					outs = null;
				}
				if (fis != null) {
					fis.close();
					fis = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		File renameFile = new File(filePath + fullFileName);
		File tempRenameFile = new File(filePath + fileUid);
		tempRenameFile.delete();
		renameFile.renameTo(tempRenameFile);
		
		return "fileList";
	}
}
