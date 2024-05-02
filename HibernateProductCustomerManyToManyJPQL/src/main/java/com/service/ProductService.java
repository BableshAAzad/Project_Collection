package com.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.entity.Customer;
import com.entity.Product;
import com.utill.EntityManagerProvider;

public class ProductService {
//	10:
	public void addProduct(Product product) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Product product2 = entityManager.find(Product.class, product.getProductId());
		if (product2 == null) {
			entityManager.persist(product);
			System.out.println("Product added successfully....!!!");
		} else
			System.out.println("Product Id already exist");
		transaction.commit();
		entityManager.close();
	}

//	11:
	public void findProductById(int productId) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("from Product p where p.productId = :pid");
		query.setParameter("pid", productId);
		Product product = (Product) query.getSingleResult();
		if (product != null)
			System.out.println(product);
		else
			System.out.println("Product Id : " + productId + " is not present in database");
		transaction.commit();
		entityManager.close();
	}

//	12:
	public void findProductBetweenPrice(int productPrice1, int productPrice2) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("from Product p where p.productPrice between :price1 and :price2");
		query.setParameter("price1", productPrice1);
		query.setParameter("price2", productPrice2);
		List<Product> products = query.getResultList();
		System.out.println("Total : " + products.size() + " products are found");
		products.forEach(System.out::println);
		transaction.commit();
		entityManager.close();
	}

//	13:
	public void findAllProductByCustomerEmail(String customerEmail) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("from Customer c where c.customerEmail = :emailId");
		query.setParameter("emailId", customerEmail);
		Customer customer = (Customer) query.getSingleResult();
		if (customer != null) {
			List<Product> products = customer.getProducts();
			if (products.size() > 0) {
				System.out.println("Total : " + products.size() + ", products bought");
				products.forEach(System.out::println);
			} else {
				System.out.println(customer.getCustomerName() + " this person not bought any products");
			}
		} else {
			System.out.println(customerEmail + " this email id is not present in database");
		}

		transaction.commit();
		entityManager.close();
	}

//	14:
	public void updateAllProductPriceByProductBrand(int productPrice, String productBrand) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("from Product p where p.productBrand = :pBrand");
		query.setParameter("pBrand", productBrand);
		List<Product> products = query.getResultList();
		if (products.size() != 0) {
			System.out.println("Total " + products.size() + " Products found");
			for (Product p : products) {
				int tempPrice = p.getProductPrice() + productPrice;
				int oldPrice = p.getProductPrice();
				p.setProductPrice(tempPrice);
				System.out.println("ProductBrandName : " + p.getProductBrand() + ", ProductName : " + p.getProductName()
						+ ", OldPrice : " + oldPrice + ", NewPrice : " + tempPrice);
				entityManager.merge(p);
			}
		} else {
			System.out.println("No product found of " + products + " brand");
		}

		transaction.commit();
		entityManager.close();
	}

//	15:
	public void deleteProductById(int productId) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("delete from Product p where p.productId = :pid");
		query.setParameter("pid", productId);
		int result = query.executeUpdate();
		if (result > 0)
			System.out.println(result + " : record deleted");
		else
			System.out.println("ProductId : " + productId + " is not present in database");

		transaction.commit();
		entityManager.close();
	}

//	16:
	public void deleteAllProductByBrand(String productBrand) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("delete from Product p where p.productBrand = ?5");
		query.setParameter(5, productBrand);
		int result = query.executeUpdate();
		if (result > 0)
			System.out.println(result + " : record deleted");
		else
			System.out.println("productBrand : " + productBrand + " is not present in database");

		transaction.commit();
		entityManager.close();
	}

//	17:
	public void deleteAllProductByCustomerEmail(String customerEmail) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("from Customer c where c.customerEmail = :cmail");
		query.setParameter("cmail", customerEmail);
		Customer customer = (Customer) query.getSingleResult();
		if (customer != null) {
			List<Product> products = customer.getProducts();
			if (products.size() > 0) {
				System.out.println("Total : " + products.size() + ", products bought");
				customer.setProducts(null);
				System.out.println("Total : " + products.size() + ", Products deleted successfully done.");
			} else {
				System.out.println(customer.getCustomerName() + " is not bought any products");
			}
		} else {
			System.out.println(customerEmail + " this email id is not present in database");
		}
		transaction.commit();
		entityManager.close();
	}

//	18:
	public void getAllProducts() {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("from Product");
		List<Product> products = query.getResultList();
		if (products.size() > 0) {
			System.out.println(products.size() + " : Product are present there -::>>");
			products.forEach(System.out::println);
		} else
			System.out.println("No Products there....!!!");

		transaction.commit();
		entityManager.close();
	}

}
