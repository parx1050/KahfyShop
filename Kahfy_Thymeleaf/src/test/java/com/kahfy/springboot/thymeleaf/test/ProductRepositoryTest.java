package com.kahfy.springboot.thymeleaf.test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.kahfy.springboot.thymeleaf.KahfyThymeleafApplication;
import com.kahfy.springboot.thymeleaf.dao.ProductRepository;
import com.kahfy.springboot.thymeleaf.entity.Product;

@Transactional
@Rollback
@SpringBootTest(classes = KahfyThymeleafApplication.class)
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	// checks to see if the repository is autowired
	@Test
	void testProductRepositoryIsNotNull() {
		Assertions.assertNotNull(productRepository);
	}

	// checks to see if you can find a product by Name
	@Test
	void findProductByIdTest() {
		Product product = new Product();
		product.setProductId(1);
		product.setName("Latte");
		product.setDescription("Espresso mixed with steamed milk.");
		product.setPrice(3.90);
		product.setRewardsWorth(3);
		Product latte = productRepository.findById(1).get();
		Assertions.assertEquals(latte.getProductId(), product.getProductId());
		Assertions.assertEquals(latte.getName(), product.getName());
		Assertions.assertEquals(latte.getDescription(), product.getDescription());
		Assertions.assertEquals(latte.getPrice(), product.getPrice());
		Assertions.assertEquals(latte.getRewardsWorth(), product.getRewardsWorth());
	}

	// checks to see if you can list all products in ascending order of their id
	@Test
	void findAllByOrderByProductIdAscTest() {
		List<Product> products = productRepository.findAllByOrderByProductIdAsc();
		boolean listedAsc = true;
		for (int i = 1; i < products.size(); i++) {
			Product currentProduct = products.get(i);
			Product lastProduct = products.get(i - 1);
			listedAsc = listedAsc && (currentProduct.getProductId() > lastProduct.getProductId());
		}
		Assertions.assertTrue(listedAsc);
	}

	// checks to see if you can save a product
	@Test
	void saveProductTest() {
		Product product = new Product();
		product.setProductId(1);
		product.setName("New Latte");
		product.setDescription("new latte description");
		product.setPrice(100.34);
		product.setRewardsWorth(47);
		productRepository.save(product);
		Product newProduct = productRepository.findById(1).get();
		Assertions.assertEquals(newProduct.getProductId(), 1);
		Assertions.assertEquals(newProduct.getName(), "New Latte");
		Assertions.assertEquals(newProduct.getDescription(), "new latte description");
		Assertions.assertEquals(newProduct.getPrice(), 100.34);
		Assertions.assertEquals(newProduct.getRewardsWorth(), 47);
	}

	// checks to see if you can product a member
	@Test
	void deleteProductByIdTest() {
		productRepository.deleteById(1);
		Assertions.assertFalse(productRepository.findById(1).isPresent());
	}

}
