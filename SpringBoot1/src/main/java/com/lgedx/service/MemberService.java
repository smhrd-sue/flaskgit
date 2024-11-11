package com.lgedx.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgedx.entity.Member;
import com.lgedx.repository.MemberRepository;

@Service
public class MemberService {

	// 요청 : Controller - Service - Mapper Interface - Mapper.xml
	// 결과 : Mapper.xml - Mapper Interface - Service - Controller

	// Controller : 요청을 받고, 응답을 하는 작업에 집중
	// Service : DB에서 가지고 온 데이터를 가공하는 작업에 집중(비지니스로직)

	@Autowired
	MemberRepository memberRepository;
	
	// 회원가입
	public Member join(Member vo) {
		return memberRepository.save(vo);
	}

	// 로그인
	public Member login(Member vo) {
		Member user = memberRepository.findByIdAndPw(vo.getId(), vo.getPw());
		
		return user;
	}

	public String idCheck(String id) {
		Optional<Member> result = memberRepository.findById(id);
		if(result.isPresent()) {
			return "중복되는 아이디입니다.";
		}else {
			return "사용가능한 아이디입니다.";
		}
	};

}
