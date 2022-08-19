package com.coffeeShopRewards.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="members")
public class Member {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="member_id")
	private int memberId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="rewards")
	private int rewards = 0;
	
	@Column(name="password")
	private String password;

	public Member() {
		super();
	}

	public Member(int memberId, String name, String email, int rewards, String password) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.email = email;
		this.rewards = rewards;
		this.password = password;
	}

	public Member(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.rewards = 0;
		this.password = password;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRewards() {
		return rewards;
	}

	public void setRewards(int rewards) {
		this.rewards = rewards;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", email=" + email + ", rewards=" + rewards + "]";
	}
	
	
}
