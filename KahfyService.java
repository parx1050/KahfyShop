package com.kahfy.springboot.thymeleaf.service;

import java.util.List;

import com.kahfy.springboot.thymeleaf.entity.Member;
import com.kahfy.springboot.thymeleaf.entity.Product;

public interface KahfyService {

	public List<Member> findAllMembers();
	
	public Member findMemberById(int theId);
	
	public void saveMember(Member theMember);
	
	public void deleteMemberById(int theId);
	
	public List<Product> findAllProducts();
	
	public Product findProductById(int theId);
	
	public void saveProduct(Product theProduct);
	
	public void deleteProductById(int theId);
	
}
