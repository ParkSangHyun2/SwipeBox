package com.sh.project.dao;

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
