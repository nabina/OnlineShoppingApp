package com.shopping.dao.impl;

import java.util.List;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.dao.ProductDao;
import com.shopping.model.Product;

@Repository
@Transactional
public class ProductDaoImp implements ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addProduct(Product product) {
		Session  session =sessionFactory.getCurrentSession();
		session.saveOrUpdate( product);
		session.flush();
		
	}

	@Override
	public Product getProductById(int productId) {
		Session  session =sessionFactory.getCurrentSession();
		Product product =(Product) session.get(Product.class,productId);
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
		Session  session =sessionFactory.getCurrentSession();
		Query query =session.createQuery("from Product");
		List<Product> products=query.list();
		session.flush();
		return products;
	}

	@Override
	public void deletProduct(Product product) {
		  Session session = sessionFactory.getCurrentSession();
	        session.delete(product);
	        session.flush();
		
	}

	@Override
	public void editProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
		
	}

}
