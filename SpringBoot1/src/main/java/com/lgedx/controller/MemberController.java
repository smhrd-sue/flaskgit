package com.lgedx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lgedx.entity.Member;
import com.lgedx.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController {
	
	// Spring의 특징 중 의존성 주입 : 스프링 내부 컨테이너에 memberService를 만들고 주입하는 것!
	@Autowired
	MemberService memberService;
	
	@GetMapping("/joinPage")
	public String joinPage() {
		System.out.println("JoinPage호출");
		return "Join";
	}
	
	@GetMapping("/loginPage")
	public String joinSuccessPage() {
		System.out.println("LoginPage호출");
		return  "Login";
	}
	
	@GetMapping("/mainPage")
	public String mainPage() {
		System.out.println("mainPage호출");
		return  "Main";
	}
	
	@GetMapping("/mailPage")
	public String mailPage() {
		System.out.println("MailPage호출");
		return  "Mail";
	}
	
	@GetMapping("/blogPage")
	public String blogPage() {
		System.out.println("blogPage호출");
		return  "Blog";
	}
	
	@PostMapping("/join")
	public String join(Member member, Model model) {
		System.out.println("회원가입 진행");
		Member result = memberService.join(member);
		if(result!= null) {
			model.addAttribute("id", member.getId());
			return "JoinSuccess";
		}
		else {
			return "Join";
		}
		
	}
	
	@PostMapping("/login")
	public String login(Member member, HttpServletRequest request) {
		System.out.println("로그인 진행");
		
		Member login_user = memberService.login(member);
		
		// session 생성
		request.getSession().setAttribute("login_user", login_user);
		
		return "Main";
	}
	
	/*
	 * @GetMapping("idCheck")
	 * 
	 * @ResponseBody public String idCheck(String id) {
	 * System.out.println("id : "+id);
	 * 
	 * return memberService.idCheck(id); }
	 */
	

}
