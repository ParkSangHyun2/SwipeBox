package com.sh.project.dao;

import java.sql.Date;

public class UserFile {
	//
	private String fileUid;
	private String userId;
	private String fileName;
	private String fileSize;
	private String fileType;
	private Date regDate;
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public UserFile() {

	}
	
	public UserFile(String userId, String fileName) {
		this.userId = userId;
		this.fileName = fileName;
	}
	public UserFile(String userUid, String userId, String fileName, String fileSize, String fileType, Date regDate) {
		this.fileUid = userUid;
		this.userId = userId;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "UserFile [userUid=" + fileUid + ", userId=" + userId + ", fileName=" + fileName + ", fileSize="
				+ fileSize + ", fileType=" + fileType + "]";
	}
	public String getFileUid() {
		return fileUid;
	}
	public void setFileUid(String fileUid) {
		this.fileUid = fileUid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
}
