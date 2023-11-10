package com.jsp.service;

import java.util.List;
import java.util.Scanner;

import com.jsp.dao1.ProductDao;
import com.jsp.entity1.Product;

public class ProductService {
	
	ProductDao productDao = new ProductDao();
	Scanner input = new Scanner(System.in);
	
	public void addProduct() {
		System.out.println("Enter product id");
		int id = input.nextInt();
		
		System.out.println("Enter Product Name:");
		String name= input.next();
		
		System.out.println("Enter product Price:");
		double price = input.nextDouble();
		
		System.out.println("Enter product quantity");
		int quantity = input.nextInt();
		
		Product product = new Product();
		product.setProductId(id);
		product.setProductName(name);
		product.setProductPrice(price);
		product.setProductQuantity(quantity);
		
		String message = productDao.addProduct(product);
		
		System.out.println(message);
	}
	
	public void getProductById() {
		System.out.println("Enter the product Id:");
		int i = input.nextInt();
		
		Product product = productDao.getProductById(i);
		if(product!=null) {
			System.out.println(product.getProductName()+","+product.getProductPrice()+","+product.getProductQuantity());
		}
		else {
			System.out.println("Invalid product Id");
		}
	}
	
	public void getAllProducts() {
		List<Product> products = productDao.getAllProducts();
		for(Product product : products ) {
			System.out.println(product.getProductName()+","+product.getProductPrice()+","+product.getProductQuantity());
		}
	}
	
	public void updateProduct() {
		System.out.println("Enter the product Id to update:");
		int id = input.nextInt();
		
		Product product = productDao.getProductById(id);
		if(product != null) {
			System.out.println(product.getProductName()+","+product.getProductPrice()+","+product.getProductQuantity());
			
			System.out.println("Enter the product name:");
			String name = input.next();
			
			System.out.println("Enter the product price");
			double price = input.nextDouble();
			
			System.out.println("Enter product quantity");
			int quantity = input.nextInt();
			
			product.setProductName(name);
			product.setProductPrice(price);
			product.setProductQuantity(quantity);
			
			String message = productDao.updateProducts(product);
			
			System.out.println(message);
		}
		else {
			System.out.println("Product is not present");
		}
	}
	 
   public void deleteProduct() {
	   System.out.println("Enter the product Id to be deleted");
	   int id = input.nextInt();
	   
	   Product product = productDao.getProductById(id);
	   
	   Product product1 = new Product();
	   if(product1 != null)
	   {
		   String products = productDao.deleteProduct(product);
		   System.out.println(products);
	   }
	   else 
		   System.out.println("Product id not present");
   }
}
