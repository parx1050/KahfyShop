package com.kahfy.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kahfy.springboot.thymeleaf.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public List<Product> findAllByOrderByProductIdAsc();

}
