package com.coffeeShopRewards.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coffeeShopRewards.springdemo.dao.CartItemDAO;
import com.coffeeShopRewards.springdemo.dao.MemberDAO;
import com.coffeeShopRewards.springdemo.dao.ProductDAO;
import com.coffeeShopRewards.springdemo.entity.CartItem;
import com.coffeeShopRewards.springdemo.entity.Member;
import com.coffeeShopRewards.springdemo.entity.Product;
import com.coffeeShopRewards.springdemo.entity.ShoppingCartSession;

@Service
public class KahfyServiceImpl implements KahfyService {
	
	private Member loggedInMember = null;
	private ShoppingCartSession currentScs = null;
	
	// need to inject the member and product dao
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CartItemDAO cartItemDAO;
	
	@Override
	@Transactional
	public List<Member> getMembers() {
		return memberDAO.getMembers();
	}
	
	@Override
	@Transactional
	public List<Product> getProducts() {
		return productDAO.getProducts();
	}
	
	@Override
	@Transactional
	public void saveMember(Member theMember) {
		memberDAO.saveMember(theMember);
		
	}
	
	@Override
	@Transactional
	public void saveProduct(Product theProduct) {
		productDAO.saveProduct(theProduct);
		
	}
	
	@Override 
	@Transactional
	public Member getMember(int theId) {
		return memberDAO.getMember(theId);
	}
	
	@Override 
	@Transactional 
	public Product getProduct(int theId) {
		return productDAO.getProduct(theId);
	}
	
	@Override 
	@Transactional 
	public void deleteMember(int theId) {
		memberDAO.deleteMember(theId);
	}
	
	@Override 
	@Transactional 
	public void deleteProduct(int theId) {
		productDAO.deleteProduct(theId);
	}
	
	@Override 
	@Transactional
	public List<CartItem> getCartItems() {
		return cartItemDAO.getCartItems(currentScs);
	}
	
	@Override 
	@Transactional
	public Member validate(String email, String password) {
		return memberDAO.validate(email, password);
	}
	
	@Override 
	@Transactional
	public void logTheMemberIn(Member theMember) {
		this.loggedInMember = theMember;
		this.currentScs = new ShoppingCartSession(theMember, 0, 0);
		cartItemDAO.saveSession(currentScs);
	}
	
	@Override 
	@Transactional 
	public void logOut() {
		this.loggedInMember = null;
		this.currentScs = null;
	}
	
	@Override 
	@Transactional 
	public Member getCurrentMember() {
		return this.loggedInMember;
	}
	
	@Override 
	@Transactional
	public boolean checkEmailExists(String email) {
		return memberDAO.checkEmailExists(email);
	}
	
	@Override 
	@Transactional
	public void createAccount(Member theMember) {
		logTheMemberIn(theMember);
		memberDAO.addMember(theMember);
	}
	
	@Override 
	@Transactional
	public CartItem getCartItem(Product p) {
		return cartItemDAO.getCartItem(currentScs, p);
	}
	
	@Override 
	@Transactional 
	public void addToCart(int theProductId) {
		Product p = productDAO.getProduct(theProductId);
		CartItem theCartItem = cartItemDAO.getCartItem(currentScs, p);
		
		if (theCartItem != null) {
			cartItemDAO.addOneToCartItem(currentScs, p);
		} else {
			theCartItem = new CartItem(currentScs, p);
			theCartItem.addOneToQuantity();
			cartItemDAO.saveCartItem(theCartItem);
			currentScs.setTotal(currentScs.getTotal() + p.getPrice());
		}
	}
	
	@Override 
	@Transactional
	public void deleteFromCart(int theProductId) {
		Product p = productDAO.getProduct(theProductId);
		CartItem theCartItem = cartItemDAO.getCartItem(currentScs, p);
		cartItemDAO.deleteFromCart(currentScs, theCartItem);
	}
	
	@Override 
	@Transactional 
	public void applyRewards(int theProductId) {
		int memberCurrentRewards = loggedInMember.getRewards();
		currentScs.setRewardsUsed(currentScs.getRewardsUsed() + 50);
		if (memberCurrentRewards >= 50) {
			Product p = productDAO.getProduct(theProductId);
			loggedInMember.setRewards(memberCurrentRewards - 50);
			CartItem theCartItem = cartItemDAO.getCartItem(currentScs, p);
			cartItemDAO.applyRewards(theCartItem);
		}
	}
	
	@Override 
	@Transactional 
	public void updateQuantity(Product p, int theQuantity) {
		cartItemDAO.updateQuantity(currentScs, p, theQuantity);
	}
	
	@Override 
	@Transactional 
	public void checkout() {
		int currentMemberRewards = loggedInMember.getRewards(); 
		int rewardsToEarn = 0;
		
		List<CartItem> theCartItems = cartItemDAO.getCartItems(currentScs);
		for (CartItem ci : theCartItems) {
			rewardsToEarn += ci.getRewardsToEarn();
		}
		
		loggedInMember.setRewards(currentMemberRewards + rewardsToEarn);
		this.currentScs = new ShoppingCartSession(loggedInMember, 0, 0);
	}

}
