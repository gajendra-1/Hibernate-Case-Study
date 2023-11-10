package com.jsp.dao1;

import java.util.List;

import com.jsp.entity1.Product;
import com.jsp.service.ProductService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ProductDao {
	Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
    
    
	public String  addProduct(Product product) {
		SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(product);
			transaction.commit();
			session.close();
			
			return "Product successfully added";
	}

	public Product getProductById(int id) {
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Product product = session.get(Product.class, id);
		transaction.commit();
		session.close();
		
		return product;
	}

	public List<Product> getAllProducts() {
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("From Product");
		List<Product> products = query.getResultList();
		transaction.commit();
		session.close();
		return products;
	}

	public String updateProducts(Product product) {
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(product);
		transaction.commit();
		session.close();
		
		return "Product successfully updated";
	}

	public String deleteProduct(Product product) {
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(product);
		transaction.commit();
		session.close();
		
		return "Product successfully deleted!";
	}
}
