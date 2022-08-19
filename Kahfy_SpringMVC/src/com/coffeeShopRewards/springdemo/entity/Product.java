package com.coffeeShopRewards.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private double price;
	
	@Column(name="reward_worth")
	private int rewardsWorth;

	public Product() {
		super();
	}

	public Product(int productId, String name, String description, double price, int rewardsWorth) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.rewardsWorth = rewardsWorth;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRewardsWorth() {
		return rewardsWorth;
	}

	public void setRewardsWorth(int rewardsWorth) {
		this.rewardsWorth = rewardsWorth;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", description=" + description + ", price=" + price + ", rewardsWorth="
				+ rewardsWorth + "]";
	}

	
}
