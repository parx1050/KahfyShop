package com.coffeeShopRewards.springdemo.dao;

import java.util.List;

import com.coffeeShopRewards.springdemo.entity.Member;

public interface MemberDAO {
	
	public List<Member> getMembers();
	
	public void saveMember(Member theMember);
	
	public Member getMember(int theId);
	
	public void deleteMember(int theId);
	
	public Member validate(String email, String password);
	
	public boolean checkEmailExists(String email);
	
	public void addMember(Member theMember);

}
