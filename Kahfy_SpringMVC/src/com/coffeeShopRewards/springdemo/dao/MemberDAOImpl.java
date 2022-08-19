package com.coffeeShopRewards.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coffeeShopRewards.springdemo.entity.Member;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Member> getMembers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query
		Query<Member> theQuery = 
				currentSession.createQuery("from Member", Member.class);
		
		// execute query and get result list
		List<Member> members = theQuery.getResultList();
				
		// return the results		
		return members;
	}
	
	@Override
	public void saveMember(Member theMember) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theMember);
	}

	@Override  
	public Member getMember(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Member theMember = currentSession.get(Member.class, theId);
		return theMember;
	}
	
	@Override 
	public void deleteMember(int theId) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		Query theQuery = currentSession.createQuery("delete from Member where id=:memberId");
		theQuery.setParameter("memberId", theId);
		theQuery.executeUpdate();
	}
	
	@Override 
	public Member validate(String email, String password) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		Query<Member> theQuery = 
				currentSession.createQuery("from Member", Member.class);
		List<Member> theMembers = theQuery.getResultList();
		Member theMember = null;
		for (Member m : theMembers) {
			if (m.getEmail().equals(email) && m.getPassword().equals(password)) { 
				theMember = m;
			}
		}
		
		return theMember;
	}
	
	@Override
	public boolean checkEmailExists(String email) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		Query<Member> theQuery = 
				currentSession.createQuery("from Member", Member.class);
		List<Member> theMembers = theQuery.getResultList();
		boolean emailExists = false;
		for (Member m : theMembers) {
			if (m.getEmail().equals(email)) { 
				emailExists = true;
			}
		}
		
		return emailExists;
	}
	
	@Override
	public void addMember(Member theMember) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		currentSession.save(theMember);
	}
}
