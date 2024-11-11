package com.lgedx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgedx.entity.UserMBTI;
import com.lgedx.repository.FlaskRepository;

@Service
public class FlaskService {
	
	@Autowired
	FlaskRepository flaskRepository;

	public void predictMbti(UserMBTI mbti) {
		flaskRepository.save(mbti);
	}
	
	

}
