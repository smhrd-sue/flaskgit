package com.lgedx.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class UserMBTI {

	@Id
	private String id;
	private String choice;
	private String mbti;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public String getMbti() {
		return mbti;
	}
	public void setMbti(String mbti) {
		this.mbti = mbti;
	}
	public UserMBTI(String id, String choice, String mbti) {
		this.id = id;
		this.choice = choice;
		this.mbti = mbti;
	}
	
	public UserMBTI() {
		
	}
	
	@Override
	public String toString() {
		return "UserMBTI [id=" + id + ", choice=" + choice + ", mbti=" + mbti + "]";
	}
	
	
}
