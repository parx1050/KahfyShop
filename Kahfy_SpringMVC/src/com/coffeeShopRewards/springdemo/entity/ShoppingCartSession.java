package com.coffeeShopRewards.springdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name="shopping_session")
public class ShoppingCartSession {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="session_id")
	private int sessionId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;
	
	@Column(name="total")
	private double total;
	
	@Column(name="rewards_used")
	private int rewardsUsed;

	public ShoppingCartSession() {
		super();
	}

	public ShoppingCartSession(int sessionId, Member member, double total, int rewardsUsed) {
		super();
		this.sessionId = sessionId;
		this.member = member;
		this.total = total;
		this.rewardsUsed = rewardsUsed;
	}
	
	public ShoppingCartSession(Member member, double total, int rewardsUsed) {
		super();
		this.member = member;
		this.total = total;
		this.rewardsUsed = rewardsUsed;
	}


	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getRewardsUsed() {
		return rewardsUsed;
	}

	public void setRewardsUsed(int rewardsUsed) {
		this.rewardsUsed = rewardsUsed;
	}

	

}
