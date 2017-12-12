package com.sh.project.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DownloadController {
	String filePath = "/Users/parksanghyun/csv/";
	String fileName = "test999.txt";
	OutputStream outs = null;
	FileInputStream fis = null;

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String downloadFile(HttpServletResponse response,
		HttpServletRequest request,
			@RequestParam(value = "file",required=true) String fullFileName) {
		
			fileName = fullFileName;
			System.out.println("in servlet" + fullFileName);
		try {
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.setHeader("Content-Disposition", "attachment;fileName=\"" + fileName + "\";");
			outs = response.getOutputStream();

			try {
				fis = new FileInputStream(filePath + fileName);
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
		return "fileList";
	}
}
