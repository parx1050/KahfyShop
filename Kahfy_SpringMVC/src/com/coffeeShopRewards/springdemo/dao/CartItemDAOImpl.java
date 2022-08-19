package com.coffeeShopRewards.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coffeeShopRewards.springdemo.entity.CartItem;
import com.coffeeShopRewards.springdemo.entity.Product;
import com.coffeeShopRewards.springdemo.entity.ShoppingCartSession;

@Repository
public class CartItemDAOImpl implements CartItemDAO {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override 
	public List<CartItem> getCartItems(ShoppingCartSession scs) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		Query<CartItem> theQuery = 
				currentSession.createQuery("from CartItem where session_id = :sessionId", CartItem.class);
		theQuery.setParameter("sessionId", scs.getSessionId());
		List<CartItem> theCartItems = theQuery.getResultList();
		return theCartItems;
	}
	
	@Override
	public CartItem getCartItem(ShoppingCartSession scs, Product p) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		Query<CartItem> theQuery = 
				currentSession.createQuery("from CartItem where session_id = :sessionId", CartItem.class);
		theQuery.setParameter("sessionId", scs.getSessionId());
		List<CartItem> theCartItems = theQuery.getResultList();
		CartItem itemExists = null;
		for (CartItem ci : theCartItems) {
			if (ci.getProduct().getProductId() == p.getProductId()) { 
				itemExists = ci;
			}
		}
		
		return itemExists;
	}
	
	@Override
	public void addOneToCartItem(ShoppingCartSession scs, Product p) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		Query<CartItem> theQuery = 
				currentSession.createQuery("from CartItem", CartItem.class);
		List<CartItem> theCartItems = theQuery.getResultList();
		for (CartItem ci : theCartItems) {
			if (ci.getSession().getSessionId() == scs.getSessionId() && ci.getProduct().getProductId() == p.getProductId()) { 
				ci.addOneToQuantity();
			}
		}
	}
	
	@Override 
	public void saveCartItem(CartItem ci) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		currentSession.merge(ci);
		
	}
	
	@Override 
	public void saveSession(ShoppingCartSession scs) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		currentSession.save(scs);
		
	}
	
	@Override
	public void applyRewards(CartItem ci) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		ci.setRewardsApplied(ci.getRewardsApplied() + 50);
		ci.setRewardsToEarn(ci.getRewardsToEarn() + ci.getProduct().getRewardsWorth());
		ci.updateSubtotalAndRewards();
		currentSession.saveOrUpdate(ci);
	}
	
	@Override
	public void updateQuantity(ShoppingCartSession scs, Product p, int theQuantity) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		Query<CartItem> theQuery = 
				currentSession.createQuery("from CartItem where session_id = :sessionId", CartItem.class);
		theQuery.setParameter("sessionId", scs.getSessionId());
		List<CartItem> theCartItems = theQuery.getResultList();
		CartItem theCartItem = null;
		for (CartItem ci : theCartItems) {
			if (ci.getProduct().getProductId() == p.getProductId()) { 
				theCartItem = ci;
			}
		}
		
		theCartItem.setQuantity(theQuantity);
		theCartItem.updateSubtotalAndRewards();
		currentSession.saveOrUpdate(theCartItem);
	}
	
	@Override
	public void deleteFromCart(ShoppingCartSession scs, CartItem ci) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		currentSession.delete(ci);
		currentSession.merge(scs);
	}
}
