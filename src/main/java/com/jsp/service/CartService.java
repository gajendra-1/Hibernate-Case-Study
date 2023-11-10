package com.jsp.service;

import java.util.Scanner;

import com.jsp.dao1.CartDao;
import com.jsp.entity1.Cart;


public class CartService 
{
	Scanner s =  new Scanner(System.in);
	CartDao cartdao = new CartDao();
	
	public void addCart()
	{
		System.out.println("Enter Cart ID");
		int id = s.nextInt();
		
		Cart cart=new Cart();
		cart.setCartId(id);
		
		String message = cartdao.addCart(cart);
		
		System.out.println(message);
	}
	
	public void addProductToCart()
	{
		System.out.println("Enter cart id for product insertion");
		int cartId = s.nextInt();
		
		System.out.println("Enter product id to be insertedd into the cart");
		int productId = s.nextInt();
		
		String message = cartdao.addProductToCart(cartId, productId);
		System.out.println(message);
	}
	
	public void removeProductFromCart()
	{
    	System.out.println("Enter cart id for product removal");
		int cartId = s.nextInt();
		
    	System.out.println("Enter product id for product removal");
		int productId = s.nextInt();
		
		String message = cartdao.removeProductFromCart(cartId, productId);
		System.out.println(message);
		
	}
}

