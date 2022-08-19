package com.coffeeShopRewards.springdemo.dao;

import java.util.List;

import com.coffeeShopRewards.springdemo.entity.CartItem;
import com.coffeeShopRewards.springdemo.entity.Product;
import com.coffeeShopRewards.springdemo.entity.ShoppingCartSession;

public interface CartItemDAO {
	
	public List<CartItem> getCartItems(ShoppingCartSession scs);
	
	public CartItem getCartItem(ShoppingCartSession scs, Product p);
	
	public void addOneToCartItem(ShoppingCartSession scs, Product p);
	
	public void saveCartItem(CartItem ci);
	
	public void saveSession(ShoppingCartSession scs);
	
	public void applyRewards(CartItem ci);
	
	public void updateQuantity(ShoppingCartSession scs, Product p, int theQuantity);
	
	public void deleteFromCart(ShoppingCartSession scs, CartItem ci);
	
}
