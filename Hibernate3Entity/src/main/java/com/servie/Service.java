package com.servie;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Cart;
import com.entity.Product;
import com.entity.User;
import com.utill.SessionProvider;

public class Service {

	public void addProduct(Product product) {
		Session session = SessionProvider.getSession();
		Transaction transaction = session.beginTransaction();
		Product existingProduct = session.get(Product.class, product.getProductId());
		if (existingProduct == null) {
			session.save(product);
			System.out.println("Product added seccesfully");
		} else {
			System.out.println("ID : " + product.getProductId() + " is already exist");
		}
		transaction.commit();
		session.close();
	}

	public void addUser(User user) {
		Session session = SessionProvider.getSession();
		Transaction transaction = session.beginTransaction();
		User existingUser = session.get(User.class, user.getUserId());
		if (existingUser == null) {
			Cart cart = new Cart();
            user.setCart(cart);
            session.save(cart);
			session.save(user);
			System.out.println("User added successfully");
		} else {
			System.out.println("User ID : " + user.getUserId() + " already exist");
		}
		transaction.commit();
		session.close();
	}

	public void addProductToCart(int userId, int productId) {
		Session session = SessionProvider.getSession();
		Transaction transaction = session.beginTransaction();
		User user = session.get(User.class, userId);
		if (user != null) {
			Product ExistingProduct = session.get(Product.class, productId);
			List<Product> products2 = user.getCart().getProducts();
			boolean contains = products2.contains(ExistingProduct);
			if (contains == false) {
				Cart cart = user.getCart();
				if (cart != null) {
					List<Product> products = cart.getProducts();
					products.add(ExistingProduct);
					session.update(cart);
					user.setCart(cart);
					session.update(user);
					System.out.println("Product added Successfully");
				} else {
					Cart cart1 = new Cart();
//					cart1.setCartId(1);
					List<Product> products1 = new ArrayList<>();
					products1.add(ExistingProduct);
					cart1.setProducts(products1);
					session.save(cart1);
					user.setCart(cart1);
					session.update(user);
					System.out.println("Product added Successfully");
				}
			} else {
				System.out.println("Product already exist");
			}
		} else {
			System.out.println("Please Enter userId first");
		}
		transaction.commit();
		session.close();
	}

	public void removeProductFromCart(int userId, int productId) {
		Session session = SessionProvider.getSession();
		Transaction transaction = session.beginTransaction();
		User user = session.get(User.class, userId);
		if (user != null) {
			Cart cart = user.getCart();
			List<Product> products = cart.getProducts();
			Product product = session.get(Product.class, productId);
			boolean remove = products.remove(product);
			session.update(cart);
			if(remove)
				System.out.println("Product removed to Cart");
			else
				System.out.println("Product not present in Cart");
		} else {
			System.out.println("Please enter correct userId");
		}
		transaction.commit();
		session.close();
	}

	public void viewAllProductsInCart(int userId) {
		Session session = SessionProvider.getSession();
		Transaction transaction = session.beginTransaction();
		User user = session.get(User.class, userId);
		List<Product> products = user.getCart().getProducts();
		System.out.println("------------Products--------------");
		products.forEach(System.out::println);
		transaction.commit();
		session.close();
	}
}
