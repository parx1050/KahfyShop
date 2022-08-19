package com.kahfy.springboot.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kahfy.springboot.thymeleaf.entity.Member;
import com.kahfy.springboot.thymeleaf.entity.Product;
import com.kahfy.springboot.thymeleaf.service.KahfyService;

@RestController
@RequestMapping("/api")
public class B2BRestController {

	private KahfyService kahfyService;
	
	@Autowired
	public B2BRestController(KahfyService theKahfyService) {
		kahfyService = theKahfyService;
	}
	
	@GetMapping("/members")
	public List<Member> findAllMembers() {
		return kahfyService.findAllMembers();
	}

	
	@GetMapping("/members/{memberId}")
	public Member getMember(@PathVariable int memberId) {
		Member theMember = kahfyService.findMemberById(memberId);
		
		if (theMember == null) {
			throw new RuntimeException("Member id not found - " + memberId);
		}
		
		return theMember;
	}

	
	@PostMapping("/members")
	public Member addMember(@RequestBody Member theMember) {
		
		theMember.setMemberId(0);
		
		kahfyService.saveMember(theMember);
		
		return theMember;
	}
	
	
	@PutMapping("/members")
	public Member updateMember(@RequestBody Member theMember) {
		
		kahfyService.saveMember(theMember);
		
		return theMember;
	}
	
	
	@DeleteMapping("/members/{memberId}")
	public String deleteMember(@PathVariable int memberId) {
		Member tempMember = kahfyService.findMemberById(memberId);
		
		
		if (tempMember == null) {
			throw new RuntimeException("Member id not found - " + memberId);
		}
		
		kahfyService.deleteMemberById(memberId);
		
		return "Deleted member id - " + memberId;
	}
	
	// ----------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return kahfyService.findAllProducts();
	}

	
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable int productId) {
		Product theProduct = kahfyService.findProductById(productId);
		
		if (theProduct == null) {
			throw new RuntimeException("Product id not found - " + productId);
		}
		
		return theProduct;
	}

	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product theProduct) {
		
		theProduct.setProductId(0);
		
		kahfyService.saveProduct(theProduct);
		
		return theProduct;
	}
	
	
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product theProduct) {
		
		kahfyService.saveProduct(theProduct);
		
		return theProduct;
	}
	
	
	@DeleteMapping("/products/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		Product tempProduct = kahfyService.findProductById(productId);
		
		
		if (tempProduct == null) {
			throw new RuntimeException("Product id not found - " + productId);
		}
		
		kahfyService.deleteProductById(productId);
		
		return "Deleted product id - " + productId;
	}
	
}










