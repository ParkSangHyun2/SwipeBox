package com.sh.project.login;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public LoginDAO() {
		System.out.println("---------loginDAO() °´Ã¼ »ý¼ºµÊ");
	}
	
	public LoginDTO login1(LoginDTO dto) {	
		LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);
		LoginDTO dto1;
		dto1=mapper.login1(dto);
		
		return dto1;
	}
	
	public int create(LoginDTO dto){
		
		LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);
		int cnt=0;
		cnt = mapper.create(dto);
		
		return cnt;
	}
}
