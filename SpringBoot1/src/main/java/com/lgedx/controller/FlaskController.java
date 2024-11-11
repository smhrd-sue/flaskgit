package com.lgedx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lgedx.entity.UserMBTI;
import com.lgedx.service.FlaskService;

@Controller
@CrossOrigin(origins = "http://13.209.58.50:5000")
public class FlaskController {
	
	@Autowired
	FlaskService flaskService;
	
	@GetMapping("/mbtiPage")
	public String inputPage() {
		System.out.println("input페이지");
		return "Input";
	}
	
//	@PostMapping("/mbti")
//	public String mbti(@JsonProperty("id") String id, @JsonProperty("choice") String choice
//			, @JsonProperty("mbti") String mbti,  Model model) {
//		System.out.println("mbit 받아옴");
//		
//		UserMBTI userMBTI = new UserMBTI(id, choice, mbti);
//		System.out.println(userMBTI.toString());
//		
//		flaskService.predictMbti(userMBTI);
//		model.addAttribute("mbti", userMBTI);
//		
//		return "Result";
//	}
	
	@PostMapping("/mbti")
	public String mbti(@RequestBody UserMBTI mbti, Model model) {
		System.out.println("mbit 받아옴");
		
		System.out.println(mbti.toString());
		
		flaskService.predictMbti(mbti);
		model.addAttribute("mbti", mbti);
		
		return "Result";
	}

}
