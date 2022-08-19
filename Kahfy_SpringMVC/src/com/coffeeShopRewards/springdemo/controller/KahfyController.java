package com.coffeeShopRewards.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coffeeShopRewards.springdemo.entity.CartItem;
import com.coffeeShopRewards.springdemo.entity.Member;
import com.coffeeShopRewards.springdemo.entity.Product;
import com.coffeeShopRewards.springdemo.service.KahfyService;

@Controller
@RequestMapping("/kahfy")
public class KahfyController {
	
	final String login = "login";
	final String home = "home";
	final String accDash = "account-dash";
	final String products = "list-products";
	final String productForm = "product-form";
	final String items = "list-cart-items";
	
	@Autowired
	private KahfyService kahfyService;
	
	@GetMapping("/home")
	public String home() {
		return home;
	}
	
	@GetMapping("/login")
	public String login() {
		return login;
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "redirect:http://localhost:8085/admin/list-items";
	}
	
	@GetMapping("/b2b")
	public String b2b() {
		return "b2b";
	}
	
	@GetMapping("/account-dash")
	public String accountDash(Model theModel) {
		theModel.addAttribute("loggedInMember", kahfyService.getCurrentMember());
		return accDash;
	}
	
	// ----------------------------------------------------------------------------------------------------------------------
	
	
	  @GetMapping("/checkMemberLogin") 
	public String checkMemberLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model theModel) {
	  
	  Member validMember = kahfyService.validate(email, password);
	  
	  if (validMember != null) {
		  kahfyService.logTheMemberIn(validMember);
		  theModel.addAttribute("loggedInMember", validMember);
		  return accDash;
	  } else {
		  theModel.addAttribute("errorMessage", "Invalid Email/Password Combination.");
		  return login;
	  }
	}
	  
	  @GetMapping("/logout")
	  public String logout(Model theModel) {
		  
		  kahfyService.logOut();
		  
		  return home;
		  
	  }
	  
	  @PostMapping("/createAccount") 
	  public String createAccount(@RequestParam("name") String name, @RequestParam("email") String email, 
			  @RequestParam("password") String password, Model theModel) {
		  boolean doesEmailExistAlready = kahfyService.checkEmailExists(email);
		  
		  if (!doesEmailExistAlready) {
			  Member theNewMember = new Member(name, email, password);
			  kahfyService.createAccount(theNewMember);
			  theModel.addAttribute("loggedInMember", theNewMember);
			  return accDash;
		  } else {
			  theModel.addAttribute("errorMessage", "Inputted Email Already Exists.");
			  return login;
		  }
	  }
	
	// ----------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/shopping-cart")
	public String listCartItems(Model theModel) {
		List<CartItem> theCartItems = kahfyService.getCartItems();
		Member theMember = kahfyService.getCurrentMember();
		
		theModel.addAttribute("cart_items", theCartItems);
		theModel.addAttribute("member", theMember);
		
		return items;
	}
	
	@GetMapping("/shopping-cart-add")
	public String addToCart(@RequestParam("productId") int theProductId, Model theModel) {
		kahfyService.addToCart(theProductId);
		
		List<CartItem> theCartItems = kahfyService.getCartItems();
		Member theMember = kahfyService.getCurrentMember();
		
		theModel.addAttribute("cart_items", theCartItems);
		theModel.addAttribute("member", theMember);
		
		return items;
	}
	
	@GetMapping("/apply-rewards")
	public String applyRewards(@RequestParam("productId") int theProductId, Model theModel) {
		kahfyService.applyRewards(theProductId);
		
		List<CartItem> theCartItems = kahfyService.getCartItems();
		Member theMember = kahfyService.getCurrentMember();
		
		theModel.addAttribute("cart_items", theCartItems);
		theModel.addAttribute("member", theMember);
		
		return items;
	}
	
	@GetMapping("/shopping-cart-edit-quantity")
	public String editQuantity(@RequestParam("productId") int theProductId, Model theModel) {
		Product theProduct = kahfyService.getProduct(theProductId);
		CartItem theCartItem = kahfyService.getCartItem(theProduct);
		
		theModel.addAttribute("cartItem", theCartItem);
		theModel.addAttribute("product", theProduct);
		
		return "edit-quantity";
	}
	
	@GetMapping("/shopping-cart-delete")
	public String deleteFromCart(@RequestParam("productId") int theProductId, Model theModel) {
		kahfyService.deleteFromCart(theProductId);
		
		List<CartItem> theCartItems = kahfyService.getCartItems();
		Member theMember = kahfyService.getCurrentMember();
		
		theModel.addAttribute("cart_items", theCartItems);
		theModel.addAttribute("member", theMember);
		
		return items;
	}
	
	@GetMapping("/checkout")
	public String checkout(Model theModel) {
		kahfyService.checkout();
		Member theMember = kahfyService.getCurrentMember();
		
		theModel.addAttribute("loggedInMember", theMember);
		return accDash;
	}
	
	@GetMapping("/updateQuantity")
	public String updateQuantity(@RequestParam("theProductId") int theProductId, @RequestParam("quantity") int theQuantity, Model theModel) {
		Product theProduct = kahfyService.getProduct(theProductId);
		kahfyService.updateQuantity(theProduct, theQuantity);
		
		List<CartItem> theCartItems = kahfyService.getCartItems();
		Member theMember = kahfyService.getCurrentMember();
		
		theModel.addAttribute("cart_items", theCartItems);
		theModel.addAttribute("member", theMember);
		
		return items;
	}
	
	@GetMapping("/member")
	public String listMembers(Model theModel) {
		
		// get members from the dao 
		List<Member> theMembers = kahfyService.getMembers();
		
		// add the members to the Model
		theModel.addAttribute("members", theMembers);
		
		return "list-members";
	}
	
	@GetMapping("/showFormForAddMember")
	public String showFormForAddMember(Model theModel) {
		
		// create model attribute to bind form data
		Member theMember = new Member();
		
		// add the members to the Model
		theModel.addAttribute("member", theMember);
		
		return "member-form";
	}
	
	@GetMapping("/showFormForUpdateMember")
	public String showFormForUpdateMember(@RequestParam("memberId") int theId, Model theModel) {
		
		// get the member from our service 
		Member theMember = kahfyService.getMember(theId);
		
		// set member as a model attribute to pre-populate the form
		theModel.addAttribute("member", theMember);
		
		return "member-form";
	}
	
	@GetMapping("/deleteMember") 
	public String deleteMember(@RequestParam("memberId") int theId) {
		kahfyService.deleteMember(theId);
		return "redirect:/kahfy/member";
	}
	
	@PostMapping("/saveMember") 
	public String saveMember(@ModelAttribute("member") Member theMember) {
		// save the member using our service 
		kahfyService.saveMember(theMember);
		
		return "redirect:/kahfy/member";
	
	}
	
	@PostMapping("/createMember") 
	public String createMember(@ModelAttribute("member") Member theMember) {
		kahfyService.saveMember(theMember);
		
		return products;
	}
	
	@PostMapping("/checkMemberLogin") 
	public String checkMemberLogin(@ModelAttribute("member") Member theMember) {
		kahfyService.saveMember(theMember);
		
		return products;
	}
	
	@GetMapping("/products")
	public String listProducts(Model theModel) {
		
		// get products from the dao 
		List<Product> theProducts = kahfyService.getProducts();
		
		// add the products to the Model
		theModel.addAttribute("products", theProducts);
		
		return products;
	}
	
	@GetMapping("/showFormForAddProduct")
	public String showFormForAddProduct(Model theModel) {
		
		// create model attribute to bind form data
		Product theProduct = new Product();
		
		// add the members to the Model
		theModel.addAttribute("product", theProduct);
		
		return productForm;
	}
	
	@GetMapping("/showFormForUpdateProduct")
	public String showFormForUpdateProduct(@RequestParam("productId") int theId, Model theModel) {
		
		// get the product from our service 
		Product theProduct = kahfyService.getProduct(theId);
		
		// set product as a model attribute to pre-populate the form
		theModel.addAttribute("product", theProduct);
		
		return productForm;
	}
	
	@GetMapping("/deleteProduct") 
	public String deleteProduct(@RequestParam("productId") int theId) {
		kahfyService.deleteProduct(theId); 
		return "redirect:/kahfy/products";
	}
	
	@PostMapping("/saveProduct") 
	public String saveProduct(@ModelAttribute("product") Product theProduct) {
		// save the member using our service 
		kahfyService.saveProduct(theProduct);
		
		return "redirect:/kahfy/products";
	
	}
}
