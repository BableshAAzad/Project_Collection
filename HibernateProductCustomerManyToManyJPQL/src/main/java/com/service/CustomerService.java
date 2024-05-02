package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.entity.Customer;
import com.entity.Product;
import com.utill.EntityManagerProvider;

public class CustomerService {
//	1:
	public void addCustomer(Customer customer, String productIds) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		String[] PIDs = productIds.split(","); // productIds = "1,3,5,6,7" => {"1", "3", "5", "6", "7"}
		List<Product> products = new ArrayList<>();
		if (PIDs.length > 0) {
			for (String i : PIDs) {
				int pid = Integer.parseInt(i);
				Product product = entityManager.find(Product.class, pid);
				if (product != null) {
					products.add(product);
				}
			}
		} else {
			System.out.println("Please select Produts as well.....");
		}
		customer.setProducts(products);
		entityManager.persist(customer);
		System.out.println("Customer and " + products.size() + " Products are Added Successfully done ..... !!!");

		transaction.commit();
		entityManager.close();
	}

//  2:
	public void findCustomerById(int customerId) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("select Customer c where c.customerId = :cid");
		query.setParameter("cid", customerId);
		Customer customer1 = (Customer) query.getSingleResult();
		if (customer1 != null) {
			System.out.println(customer1);
		} else {
			System.out.println("CustomerId : " + customerId + ", is not present in database");
		}

		transaction.commit();
		entityManager.close();
	}

//  3:
	public void findCustomerByAddress(String customerAddress) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("select Customer c where c.customerAddress = :cAddress");
		query.setParameter("cAddress", customerAddress);
		List<Customer> cutomers = query.getResultList();
		if (cutomers.size() > 0) {
			System.out
					.println("Total : " + cutomers.size() + ", Customer found on " + customerAddress + " this address");
			for (Customer c : cutomers) {
				System.out.println(c);
			}
		} else {
			System.out.println("No Customer present on this address");
		}

		transaction.commit();
		entityManager.close();
	}

//  4:
	public void findAllCustomersByProductName(String productName) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("from Product p where p.productName = :pname");
		query.setParameter("pname", productName);
		Product product1 = (Product) query.getSingleResult();
		if (product1 != null) {
			List<Customer> customers = product1.getCustomers();
			if (customers.size() > 0) {
				System.out.println("Total : " + customers.size() + ", customers bought this product : " + productName);
				customers.forEach(System.out::println);
			} else {
				System.out.println("Not bought any one this product : " + productName);
			}
		} else {
			System.out.println(productName + " this product is not present in database");
		}
		transaction.commit();
		entityManager.close();
	}

//  5:
	public void updateCustomerAddressByEmail(String cutomerEmail, String customerNewAddress) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager
				.createQuery("update Customer c set c.customerAddress = :cAddress where c.customerEmail = :cEmail");
		query.setParameter("cAddress", customerNewAddress);
		query.setParameter("cEmail", cutomerEmail);
		int result = query.executeUpdate();
		if (result > 0)
			System.out.println(result + " Customer Address Updated successfully done");
		else
			System.out.println(cutomerEmail + " this email id is not present in database");
		transaction.commit();
		entityManager.close();
	}

//  6:
	public void deleteCustomerById(int customerId) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("delete from Customer c where c.customerId = :cid");
		query.setParameter("cid", customerId);
		int result = query.executeUpdate();
		if (result > 0)
			System.out.println(result + " Customer successfully deleted done.");
		else
			System.out.println(customerId + " this id is not present in database");

		transaction.commit();
		entityManager.close();
	}

//  7:
	public void deleteCustomerByEmail(String customerEmail) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("delete from Customer c where c.customerEmail = :eid");
		query.setParameter("eid", customerEmail);
		int result = query.executeUpdate();
		if (result > 0)
			System.out.println(result + " Customer successfully deleted done.");
		else
			System.out.println(customerEmail + " this email id is not present in database");

		transaction.commit();
		entityManager.close();
	}

//  8:
	public void deleteAllCustomersByProductId(int productId) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("from Product p where p.productId = :pid");
		query.setParameter("pid", productId);
		Product product = (Product) query.getSingleResult();
		if (product != null) {
			List<Customer> customers = product.getCustomers();
			System.out.println(
					"Total : " + customers.size() + ", Customer bought this product :> " + product.getProductName());
			for (Customer c : customers) {
				entityManager.remove(c);
			}
			System.out.println("Total : " + customers.size() + ", Customers are deleted successfully done");
		} else {
			System.out.println("ProductID : " + productId + ", is not present in database");
		}
		transaction.commit();
		entityManager.close();
	}

//  9:
	public void getAllCutomers() {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Query query = entityManager.createQuery("from Customer");
		List<Customer> customers = query.getResultList();
		if (customers.size() > 0) {
			System.out.println("Total : " + customers.size() + ", Customer are present here");
			customers.forEach(System.out::println);
		} else {
			System.out.println("No Customers Present here");
		}

		transaction.commit();
		entityManager.close();
	}
}
