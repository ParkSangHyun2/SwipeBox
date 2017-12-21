package com.sh.project.login;

public class LoginDTO {
	private String id;
	private String coid;
	private String passwd;	
	private String tel;
	
	private String inpSaveId;
	private String coNum;
	private String name;
	private String email;
	
	private String prevPage;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCoid() {
		return coid;
	}

	public void setCoid(String coid) {
		this.coid = coid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getInpSaveId() {
		return inpSaveId;
	}

	public void setInpSaveId(String inpSaveId) {
		this.inpSaveId = inpSaveId;
	}

	public String getCoNum() {
		return coNum;
	}

	public void setCoNum(String coNum) {
		this.coNum = coNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(String prevPage) {
		this.prevPage = prevPage;
	}

	@Override
	public String toString() {
		return "LoginDTO [id=" + id + ", coid=" + coid + ", passwd=" + passwd + ", tel=" + tel + ", inpSaveId="
				+ inpSaveId + ", coNum=" + coNum + ", name=" + name + ", email=" + email + ", prevPage=" + prevPage
				+ "]";
	}
	
}
