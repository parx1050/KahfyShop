package com.coffeeShopRewards.springdemo.service;

import java.util.List;

import com.coffeeShopRewards.springdemo.entity.CartItem;
import com.coffeeShopRewards.springdemo.entity.Member;
import com.coffeeShopRewards.springdemo.entity.Product;

public interface KahfyService {
	
	public List<Member> getMembers();
	
	public List<Product> getProducts();
	
	public void saveMember(Member theMember);
	
	public void saveProduct(Product theProduct);
	
	public Member getMember(int theId);
	
	public Product getProduct(int theId);
	
	public void deleteMember(int theId);
	
	public void deleteProduct(int theId);
	
	public List<CartItem> getCartItems();
	
	public Member validate(String email, String password);
	
	public void logTheMemberIn(Member theMember);
	
	public void logOut();
	
	public Member getCurrentMember();
	
	public boolean checkEmailExists(String email);
	
	public void createAccount(Member theMember);
	
	public CartItem getCartItem(Product p);
	
	public void addToCart(int theProductId);
	
	public void deleteFromCart(int theProductId);
	
	public void applyRewards(int theProductId);
	
	public void updateQuantity(Product p, int theQuantity);
	
	public void checkout();

}
