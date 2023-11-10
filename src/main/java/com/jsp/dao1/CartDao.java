package com.jsp.dao1;

import java.util.Scanner;

import com.jsp.entity1.Cart;
import com.jsp.entity1.Product;
import com.jsp.service.CartService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CartDao 
{
	Scanner s=new Scanner(System.in);
	Configuration cfg = new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);

	public String addCart(Cart cart)
	{
	    SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(cart);
		transaction.commit();
		session.close();
    	
    	return "One cart added. CartId: "+cart.getCartId();
	}
	
	public String addProductToCart(int cartId,  int productId)
	{
	    SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
    	
		Cart cart = session.find(Cart.class, cartId);
		Product product = session.find(Product.class, productId);
		
		cart.getProducts().add(product);
		
		session.save(cart);
		
		transaction.commit();
		session.close();
		
		return "Product addded to the Cart";
	}
	
	public String removeProductFromCart(int cartId,  int productId)
	{
	    SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

    	Cart cart = session.find(Cart.class, cartId);
    	Product product = session.find(Product.class, productId);
    	
    	cart.getProducts().remove(product);
    	session.merge(cart);
		
		transaction.commit();
		session.close();
    	
		return "Product Removed";
	}
}

