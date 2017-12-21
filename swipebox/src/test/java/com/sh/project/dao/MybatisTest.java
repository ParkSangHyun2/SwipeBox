package com.sh.project.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MybatisTest {
	private static final Logger log = LoggerFactory.getLogger(MybatisTest.class);
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setup() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void selectAll() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Collection<?> foundFile = session.selectList("FileMapper.selectAll", "pus5684");
			log.debug("userFile : {}", foundFile);
			System.out.println(foundFile);
		} finally {
			session.close();
		}
	}

	@Test
	public void select() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserFileDAO file = new UserFileDAO("pus5684", "test");
			UserFileDAO foundFile = session.selectOne("FileMapper.selectFile", file);
			System.out.println(foundFile);
		} finally {
			session.close();
		}
	}

	@Test
	public void insert() {
		SqlSession session = sqlSessionFactory.openSession();
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		try {
			UserFileDAO file = new UserFileDAO("20171213131121", "pus5684", "test", "1 MB", "txt", sqlDate);
			UserFileDAO userFile = session.selectOne("FileMapper.insertFile", file);
			System.out.println(userFile);
		} finally {
			session.close();
		}
	}

	@Test
	public void delete() {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			UserFileDAO file = new UserFileDAO("pus5684", "test");
			int userFile = session.delete("FileMapper.deleteFile", file);
			session.commit();
			System.out.println(userFile);
		} finally {
			session.close();
		}
	}

}
