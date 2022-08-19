package com.kahfy.springboot.thymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kahfy.springboot.thymeleaf.entity.Member;
import com.kahfy.springboot.thymeleaf.entity.Product;
import com.kahfy.springboot.thymeleaf.service.KahfyService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private KahfyService kahfyService;
	
	public AdminController(KahfyService theKahfyService) {
		kahfyService = theKahfyService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list-items")
	public String listItems(Model theModel) {
		
		// get members and products from db
		List<Member> theMembers = kahfyService.findAllMembers();
		List<Product> theProducts = kahfyService.findAllProducts();
		
		// add to the spring model
		theModel.addAttribute("members", theMembers);
		theModel.addAttribute("products", theProducts);
		
		return "dashboard/list-items";
	}
	
	@GetMapping("/showFormForAddMember")
	public String showFormForAddMember(Model theModel) {
		
		// create model attribute to bind form data
		Member theMember = new Member();
		
		theModel.addAttribute("member", theMember);
		
		return "dashboard/member-form";
	}

	@GetMapping("/showFormForUpdateMember")
	public String showFormForUpdateMember(@RequestParam("memberId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Member theMember = kahfyService.findMemberById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("member", theMember);
		
		// send over to our form
		return "dashboard/member-form";			
	}
	
	@GetMapping("/showFormForAddProduct")
	public String showFormForAddProduct(Model theModel) {
		
		// create model attribute to bind form data
		Product theProduct = new Product();
		
		theModel.addAttribute("product", theProduct);
		
		return "dashboard/product-form";
	}

	@GetMapping("/showFormForUpdateProduct")
	public String showFormForUpdateProduct(@RequestParam("productId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Product theProduct = kahfyService.findProductById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("product", theProduct);
		
		// send over to our form
		return "dashboard/product-form";			
	}
	
	
	@PostMapping("/saveMember")
	public String saveMember(@ModelAttribute("member") Member theMember) {
		
		// save the employee
		kahfyService.saveMember(theMember);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/list-items";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product theProduct) {
		
		// save the employee
		kahfyService.saveProduct(theProduct);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/list-items";
	}
	
	@GetMapping("/deleteMember")
	public String deleteMember(@RequestParam("memberId") int theId) {
		kahfyService.deleteMemberById(theId);
		return "redirect:/admin/list-items";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId") int theId) {
		kahfyService.deleteProductById(theId);
		return "redirect:/admin/list-items";
	}
	
	
}












