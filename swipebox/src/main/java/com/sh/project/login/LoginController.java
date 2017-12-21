package com.sh.project.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired
	private LoginDAO dao;
	
	public LoginController() {
		System.out.println("----loginCont() ��ü ������");
	}
	
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		//���������� url�� ����
		String referrer = request.getHeader("Referer");
		
		//���������� ������ ������ login.jsp�� �̵�
		mav.setViewName("login");
		mav.addObject("prevPage", referrer);
		return mav;		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginProc(LoginDTO dto, HttpSession session, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		
		LoginDTO dto1=dao.login1(dto);
//		System.out.println(dto.toString());
		
		if(dto1!=null){
				// ���ǿ� ���̵� ����
				session.setAttribute("s_id", dto1.getId());
				// ID ��Ű����			
				session.setAttribute("fail", 0);
				Cookie cookie = null;
					
				if("SAVE".equals(dto.getInpSaveId())) {	
					cookie = new Cookie("c_id", dto1.getId());							
					cookie.setMaxAge(60*60*24*30);		// �����ȿ�Ⱓ : �����Ⱓ �� 1����				
				} else{	 
					cookie = new Cookie("c_id", "");					
					cookie.setMaxAge(0);			
					
				}
				
				response.addCookie(cookie);			   // ����� PC�� ��Ű�� ����			
				//mav.setViewName("redirect:./home.jsp");
				mav.setViewName("redirect:/" );	//
				
		}else{
				session.setAttribute("fail", 1);
				mav.setViewName("redirect:login");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpSession session, HttpServletResponse response) throws IOException{
		ModelAndView mav = new ModelAndView();
		//�������� �����
		session.removeAttribute("s_id");
		session.removeAttribute("fail");
				
// 		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("<script>");
//		out.println("alert('�α׾ƿ��Ǿ����ϴ�!!!');");
//		//out.println("history.back();");
//		out.println("location.href='/project'");
//		out.println("</script>");
//		out.flush();
		
		mav.setViewName("redirect:/");
		return mav;
				
	}
	
	//ȸ������ Ŭ���� ������� �̵�
	@RequestMapping(value="/agreement", method= RequestMethod.GET)
	public ModelAndView agreement(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		//login.jsp�� �̵�
		mav.setViewName("agreement");
		return mav;		
	}
	
	//������������� ȸ������ ������ �̵�
	@RequestMapping(value="/member", method= RequestMethod.GET)
	public ModelAndView member(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		// memberForm.jsp�� �̵�
		mav.setViewName("member");
		return mav;		
	}
	
	@RequestMapping(value="/member", method=RequestMethod.POST)
	public ModelAndView memberProc(LoginDTO dto, HttpServletResponse response) throws IOException{
		ModelAndView mav = new ModelAndView();
		System.out.println(dto.toString());
		//�����ͺ��̽����� ����Ȯ��(�´��� �ƴ���)
		int cnt=dao.create(dto);
		
		
		if(cnt==0){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('ȸ�����Կ� �����ϼ̽��ϴ� �ٽýõ����ּ���!!');");
			//out.println("history.back();");
			out.println("location.href='/project'");
			out.println("</script>");
			out.flush();
				
			//System.out.println("����");
			mav.setViewName("redirect:login");
				
		}else{
			
//			response.setContentType("text/html; charset=utf-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("alert('ȸ�����Կ� �����ϼ̽��ϴ�!! �α������ּ��� ');");
//			//out.println("history.back();");
//			out.println("location.href='./login'");
//			out.println("</script>");
//			out.flush();
			//System.out.println("����");
			mav.setViewName("redirect:login");
		}
		
		return mav;
	}
	
}
