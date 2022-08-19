package com.kahfy.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kahfy.springboot.thymeleaf.dao.MemberRepository;
import com.kahfy.springboot.thymeleaf.dao.ProductRepository;
import com.kahfy.springboot.thymeleaf.entity.Member;
import com.kahfy.springboot.thymeleaf.entity.Product;

@Service
public class KahfyServiceImpl implements KahfyService {

	private MemberRepository memberRepo;
	private ProductRepository productRepo;
	
	@Autowired
	public KahfyServiceImpl(MemberRepository theMemberRepo, ProductRepository theProductRepo) {
		memberRepo = theMemberRepo;
		productRepo = theProductRepo;
	}
	
	@Override
	public List<Member> findAllMembers() {
		return memberRepo.findAllByOrderByMemberIdAsc();
	}

	@Override
	public Member findMemberById(int theId) {
		Optional<Member> result = memberRepo.findById(theId);
		
		Member theMember = null;
		
		if (result.isPresent()) {
			theMember = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find member id - " + theId);
		}
		
		return theMember;
	}

	@Override
	public void saveMember(Member theMember) {
		memberRepo.save(theMember);
	}

	@Override
	public void deleteMemberById(int theId) {
		memberRepo.deleteById(theId);
	}
	
	@Override
	public List<Product> findAllProducts() {
		return productRepo.findAllByOrderByProductIdAsc();
	}

	@Override
	public Product findProductById(int theId) {
		Optional<Product> result = productRepo.findById(theId);
		
		Product theProduct = null;
		
		if (result.isPresent()) {
			theProduct = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find product id - " + theId);
		}
		
		return theProduct;
	}

	@Override
	public void saveProduct(Product theProduct) {
		productRepo.save(theProduct);
	}

	@Override
	public void deleteProductById(int theId) {
		productRepo.deleteById(theId);
	}

}






