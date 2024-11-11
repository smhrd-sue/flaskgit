package com.lgedx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lgedx.entity.UserMBTI;


@Repository
public interface FlaskRepository extends JpaRepository<UserMBTI, String>{

}
