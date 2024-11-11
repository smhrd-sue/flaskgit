package com.lgedx.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity // 테이블로 만드는 어노테이션
@Data // 필요한 Getter, Setter 등 메소드들을 자동으로 생성
public class Member { // VO <-- ORM --> Table
	
	@Id
	private String id;
	private String pw;
	private String name;
	@Column(insertable = false, updatable=false, columnDefinition = "DATE DEFAULT SYSDATE")
	private Date joinDate;

}
