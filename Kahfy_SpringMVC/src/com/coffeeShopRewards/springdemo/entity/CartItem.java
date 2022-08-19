package com.coffeeShopRewards.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name="cart_item")
public class CartItem {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="item_id")
	private int itemId;
	
	@ManyToOne
    @JoinColumn(name="session_id", nullable=false)
    private ShoppingCartSession session;
	
	@OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
	
	@Column(name="quantity") 
	private int quantity;
	
	@Column(name="rewards_applied")
	private int rewardsApplied;
	
	@Column(name="rewards_to_earn")
	private int rewardsToEarn;
	
	@Column(name="subtotal")
	private double subtotal;

	public CartItem() {
		super();
	}

	public CartItem(int itemId, ShoppingCartSession session, Product product, int quantity, int rewardsApplied, int rewardsToEarn, double subtotal) {
		super();
		this.itemId = itemId;
		this.session = session;
		this.product = product;
		this.quantity = quantity;
		this.rewardsApplied = rewardsApplied;
		this.rewardsToEarn = rewardsToEarn; 
		this.subtotal = subtotal;
	}

	public CartItem(ShoppingCartSession session, Product product) {
		super();
		this.session = session;
		this.product = product;
		this.quantity = 0;
		this.rewardsApplied = 0;
		this.rewardsToEarn = 0; 
		this.subtotal = 0;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public ShoppingCartSession getSession() {
		return session;
	}

	public void setSession(ShoppingCartSession session) {
		this.session = session;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getRewardsApplied() {
		return rewardsApplied;
	}

	public void setRewardsApplied(int rewardsApplied) {
		this.rewardsApplied = rewardsApplied;
	}

	public int getRewardsToEarn() {
		return rewardsToEarn;
	}

	public void setRewardsToEarn(int rewardsToEarn) {
		this.rewardsToEarn = rewardsToEarn;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
	public void addOneToQuantity() {
		this.quantity++;
		int rewardsWorth = this.product.getRewardsWorth();
		this.rewardsToEarn += rewardsWorth;
		double price = this.product.getPrice(); 
		this.subtotal += price;
	}
	
	public void updateSubtotalAndRewards() {
		this.subtotal = (this.quantity * this.product.getPrice()) - (this.product.getPrice() * (this.rewardsApplied / 50));
		this.rewardsToEarn = (this.product.getRewardsWorth() * this.quantity) - (this.product.getRewardsWorth() * (this.rewardsApplied / 50));
	}
	
}
