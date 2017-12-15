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
		System.out.println("----loginCont() 생성");
	}
	
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		String referrer = request.getHeader("Referer");
		
		mav.setViewName("login");
		mav.addObject("prevPage", referrer);
		return mav;		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginProc(LoginDTO dto, HttpSession session, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		
		LoginDTO dto1=dao.login1(dto);
		
		
		if(dto1!=null){
				
				session.setAttribute("s_id", dto1.getId());
				session.setAttribute("fail", 0);			
				Cookie cookie = null;
					
				if("SAVE".equals(dto.getInpSaveId())) {	
					cookie = new Cookie("c_id", dto1.getId());							
					cookie.setMaxAge(60*60*24*30);				
				} else{	 
					cookie = new Cookie("c_id", "");					
					cookie.setMaxAge(0);			
					
				}
				
				response.addCookie(cookie);			   			
				//mav.setViewName("redirect:./home.jsp");
//				mav.setViewName("redirect:" + dto.getPrevPage()+ "");	//
				mav.setViewName("redirect:/");	//
				
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
//		out.println("alert('로그아웃되셨습니다!!!');");
//		//out.println("history.back();");
//		out.println("location.href='/project'");
//		out.println("</script>");
//		out.flush();
		
		mav.setViewName("redirect:/");
		return mav;
				
	}
	
	
	@RequestMapping(value="/agreement", method= RequestMethod.GET)
	public ModelAndView agreement(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		//login.jsp로 이동
		mav.setViewName("agreement");
		return mav;		
	}
	
	
	@RequestMapping(value="/member", method= RequestMethod.GET)
	public ModelAndView member(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("member");
		return mav;		
	}
	
	@RequestMapping(value="/member", method=RequestMethod.POST)
	public ModelAndView memberProc(LoginDTO dto, HttpServletResponse response) throws IOException{
		ModelAndView mav = new ModelAndView();
		//System.out.println(dto.toString());
		
		int cnt=dao.create(dto);
		
		
		if(cnt==0){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입에 실패하셨습니다!!');");
			out.println("history.back();");
			//out.println("location.href='/project'");
			out.println("</script>");
			out.flush();
				
			mav.setViewName("redirect:/");
				
		}else{
			
			/*response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert(' ');");
			//out.println("history.back();");
			out.println("location.href='./login'");
			out.println("</script>");
			out.flush();*/
			//System.out.println("");
			mav.setViewName("redirect:/");
		}
		return mav;
	}
	
	@RequestMapping(value="/idcheck", method= RequestMethod.GET)
	public ModelAndView idcheck(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("idCheckForm");
		return mav;		
	}
	
	@RequestMapping(value="/idcheck", method=RequestMethod.POST)
	public ModelAndView idChekProc(LoginDTO dto, HttpServletResponse response) throws IOException{
		ModelAndView mav = new ModelAndView();
		
		//LoginDAO dao = new LoginDAO(); ※마이바티스 사용시 dao를 new로 사용하면 nullpoint error
		
		System.out.println("controler  "+dto.getId());
		
		int cnt = dao.idcheck(dto);
		System.out.println(cnt);
		
		mav.addObject("id", dto.getId());
		mav.addObject("cnt", /*new Integer(cnt)*/ cnt);
		mav.setViewName("idCheckProc");
		
		return mav;
	}
}
