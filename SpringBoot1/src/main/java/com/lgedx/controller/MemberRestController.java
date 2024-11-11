package com.lgedx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lgedx.service.MemberService;

//@ResponseBody + @Controller = @RestController
//데이터를 응답할 controller
@RestController 
public class MemberRestController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("idCheck")
	public String idCheck(String id) {
		System.out.println("id : "+id);
		
		return memberService.idCheck(id);
	}

}
