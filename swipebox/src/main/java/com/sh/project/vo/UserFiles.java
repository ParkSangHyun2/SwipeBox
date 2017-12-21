package com.sh.project.vo;

import java.util.ArrayList;
import java.util.List;

public class UserFiles {
	//
	private List<PersonalFile> files = new ArrayList<PersonalFile>();
	
	public void addFile(PersonalFile file) {
		//
		files.add(file);
	}
	
	public List<PersonalFile> list(){
		return files;
	}
}
