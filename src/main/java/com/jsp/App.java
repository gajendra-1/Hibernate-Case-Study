package com.jsp;

import java.util.Scanner;

import com.jsp.service.ProductService;
import com.jsp.service.*;
/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				" 1.To add the product \n"
				+ " 2.To get the product by ID\n"
				+ " 3.Get all the products\n"
				+ " 4.To update the product \n"
				+ " 5.To delete the products \n"
				+ " 6.To add the cart \n"
				+ " 7.To add product to the cart \n"
				+ " 8.To remove the product from the cart\n"
				+ " 0.To terminate the program");
		int choice = sc.nextInt();

		ProductService productService = new ProductService();
		CartService cart = new CartService();
		
		switch (choice) {
			case 1:
				productService.addProduct();
				break;
			case 2:
				productService.getProductById();
				break;
			case 3:
				productService.getAllProducts();
				break;
			case 4:
				productService.updateProduct();
				break;
			case 5:
				productService.deleteProduct();
				break;
			case 6:
				cart.addCart();
				break;
			case 7:
				cart.addProductToCart();
				break;
			case 8:
				cart.removeProductFromCart();
				break;
			case 0:
				System.out.println("Program Terminated!");
			default:
				System.out.println("Invalid Choice");
				break;
		}
	}
}
