package com.coffeeShopRewards.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coffeeShopRewards.springdemo.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getProducts() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query
		Query<Product> theQuery = 
				currentSession.createQuery("from Product", Product.class);
		
		// execute query and get result list
		List<Product> products = theQuery.getResultList();
				
		// return the results		
		return products;
	}
	
	@Override
	public void saveProduct(Product theProduct) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theProduct);
	}
	
	@Override 
	public Product getProduct(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Product theProduct = currentSession.get(Product.class, theId);
		return theProduct;
	}
	
	@Override 
	public void deleteProduct(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Product where id=:productId");
		theQuery.setParameter("productId", theId); 
		theQuery.executeUpdate();
	}

}
