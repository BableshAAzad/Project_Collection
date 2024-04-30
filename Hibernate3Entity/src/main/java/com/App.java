package com;

import java.util.Scanner;

import com.entity.Product;
import com.entity.User;
import com.servie.Service;

class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the below options : ");
		System.out.println(
				"\n1 : Add Product\n2 : Add User\n3 : Add Products to cart\n4 : Remove Products from cart\n5 : View all Products in Cart");
		int options = sc.nextInt();
		Service service = new Service();
		switch (options) {
		case 1:
			System.out.println("Enter Product Id : ");
			int productId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter product name : ");
			String productName = sc.nextLine();
			System.out.println("Enter product Brand : ");
			String productBrand = sc.nextLine();
			System.out.println("Enter product price : ");
			int productPrice = sc.nextInt();
			Product product = new Product();
			product.setProductId(productId);
			product.setProductName(productName);
			product.setProductBrand(productBrand);
			product.setProductPrice(productPrice);
			service.addProduct(product);
			break;
		case 2:
			System.out.println("Enter User Id : ");
			int userId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter User Name : ");
			String userName = sc.nextLine();
			System.out.println("Enter User Email Id : ");
			String userEmail = sc.nextLine();
			System.out.println("Enter User Age : ");
			int userAge = sc.nextInt();
			User user = new User();
			user.setUserId(userId);
			user.setUserName(userName);
			user.setUserEmail(userEmail);
			user.setUserAge(userAge);
			service.addUser(user);
			break;
		case 3:
			System.out.println("Enter User Id : ");
			int userId1 = sc.nextInt();
			System.out.println("Enter Product Id : ");
			int productId1 = sc.nextInt();
			service.addProductToCart(userId1, productId1);
			break;
		case 4:
			System.out.println("Enter User Id : ");
			int userId2 = sc.nextInt();
			System.out.println("Enter Product Id : ");
			int productId2 = sc.nextInt();
			service.removeProductFromCart(userId2, productId2);
			break;
		case 5:
			System.out.println("Enter User Id : ");
			int userId3 = sc.nextInt();
			service.viewAllProductsInCart(userId3);
			break;
		default:
			break;
		}
	}
}
