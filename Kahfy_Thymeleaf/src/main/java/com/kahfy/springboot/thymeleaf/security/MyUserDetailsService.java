package com.kahfy.springboot.thymeleaf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kahfy.springboot.thymeleaf.dao.MemberRepository;
import com.kahfy.springboot.thymeleaf.entity.Member;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired 
	private MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Member member = memberRepository.findById(1).get();
		
		if (member == null) {
			throw new UsernameNotFoundException("Member 404");
		}
		
		return new MemberPrincipal(member);
	}

}
