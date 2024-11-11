package com.lgedx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lgedx.entity.Member;

@Repository 											// <필요한 엔티티, pk의 타입>
public interface MemberRepository extends JpaRepository<Member, String>{
	
	// 쿼리메소드
	// find+엔티티이름+By+변수이름
	Member findByIdAndPw(String id, String pw);
	

}
