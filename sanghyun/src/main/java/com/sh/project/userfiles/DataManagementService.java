package com.sh.project.userfiles;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sh.project.dao.UserFileDAO;
import com.sh.project.dao.UserFileDAO;

public class DataManagementService {
	
	private static final Logger log = LoggerFactory.getLogger(DataManagementService.class);
	private SqlSessionFactory sqlSessionFactory;
	
	public DataManagementService() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	public Collection<UserFileDAO> selectAll(String userId) throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		Collection<UserFileDAO> foundFiles;
		try {
			foundFiles = session.selectList("FileMapper.selectAll", userId);
			log.debug("userFile : {}", foundFiles);
			System.out.println(foundFiles);
		} finally {
			session.close();
		}
		return foundFiles;
	}
	
	public UserFileDAO selectByUid(String fileUid) {
		SqlSession session = sqlSessionFactory.openSession();
		UserFileDAO foundFile;
		try {
			UserFileDAO file = new UserFileDAO(fileUid);
			foundFile = session.selectOne("FileMapper.selectByUid", file);
			System.out.println(foundFile);
		} finally {
			session.close();
		}
		return foundFile;
	}

	public UserFileDAO select(String userId, String fileName) {
		SqlSession session = sqlSessionFactory.openSession();
		UserFileDAO foundFile;
		try {
			UserFileDAO file = new UserFileDAO(userId, fileName);
			foundFile = session.selectOne("FileMapper.selectFile", file);
			System.out.println(foundFile);
		} finally {
			session.close();
		}
		return foundFile;
	}

	public void insert(UserFileDAO insertFile) {
		SqlSession session = sqlSessionFactory.openSession();
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		insertFile.setRegDate(sqlDate);

		try {
			//UserFileDAO file = new UserFileDAO("20171213131121", "pus5684", "test", "1 MB", "txt", sqlDate);
			
			UserFileDAO userFile = session.selectOne("FileMapper.insertFile", insertFile);
			System.out.println(userFile);
		} finally {
			session.close();
		}
	}

	public void delete(String userId, String fileName) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			UserFileDAO file = new UserFileDAO(userId, fileName);
			int userFile = session.delete("FileMapper.deleteFile", file);
			session.commit();
			System.out.println(userFile);
		} finally {
			session.close();
		}
	}

}
