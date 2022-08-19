package com.kahfy.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kahfy.springboot.thymeleaf.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{
	
	public List<Member> findAllByOrderByMemberIdAsc();

}
