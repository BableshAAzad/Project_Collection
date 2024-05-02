package com;

import java.util.Scanner;

import com.entity.Customer;
import com.entity.Product;
import com.service.CustomerService;
import com.service.ProductService;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ProductService productService = new ProductService();
		CustomerService customerService = new CustomerService();
		System.out.println("Enter Below Opetion : ");
		System.out.println(
				"1 : Add Customer\n2 : Find Customer By Id\n3 : Find Customer By Address\n4 : Find All Customers By Product Name\n5 : Update Customer Address By Email\n6 : Delete Customer By Id\n7 : Delete Customer By Email\n8 : Delete All Customers By Product Id\n9 : Get All Cutomers");
		System.out.println("-----------------------------------------");
		System.out.println(
				"10 : Add Product\n11 : Find Product By Id\n12 : Find Product Between Price\n13 : Find All Product By Customer Email\n14 : Update All Product Price By Product Brand\n15 : Delete Product By Id\n16 : Delete All Product By Brand\n17 : Delete All Product By Customer Email\n18 : Get All Products");
		System.out.println("00 : For Exit");
		int n = scanner.nextInt();
		switch (n) {
		case 1:
			System.out.println("Enter Customer Id : ");
			int customerId = scanner.nextInt();
			System.out.println("Enter Customer Name : ");
			scanner.nextLine();
			String customerName = scanner.nextLine();
			System.out.println("Enter Customer Email : ");
			String customerEmail = scanner.nextLine();
			System.out.println("Enter Customer Address : ");
			String customerAddress = scanner.nextLine();
			Customer customer = new Customer();
			customer.setCustomerId(customerId);
			customer.setCustomerName(customerName);
			customer.setCustomerEmail(customerEmail);
			customer.setCustomerAddress(customerAddress);
			productService.getAllProducts();
			System.out.println("Enter Product IDs format like(1,2,3,4......):");
			String productIds = scanner.nextLine();
			customerService.addCustomer(customer, productIds);
			break;
		case 2:
			System.out.println("Enter Customer Id : ");
			int customerId1 = scanner.nextInt();
			customerService.findCustomerById(customerId1);
			break;
		case 3:
			System.out.println("Enter Customer Address : ");
			scanner.nextLine();
			String customerAddress1 = scanner.nextLine();
			customerService.findCustomerByAddress(customerAddress1);
			break;
		case 4:
			System.out.println("Enter ProductName : ");
			scanner.nextLine();
			String productNameC = scanner.nextLine();
			customerService.findAllCustomersByProductName(productNameC);
			break;
		case 5:
			System.out.println("Enter Customer Email : ");
			scanner.nextLine();
			String cutomerEmail = scanner.nextLine();
			System.out.println("Enter Customer New Address : ");
			String customerNewAddress = scanner.nextLine();
			customerService.updateCustomerAddressByEmail(cutomerEmail, customerNewAddress);
			break;
		case 6:
			System.out.println("Enter Customer Id : ");
			int customerId2 = scanner.nextInt();
			customerService.deleteCustomerById(customerId2);
			break;
		case 7:
			System.out.println("Enter Customer Email Id : ");
			scanner.nextLine();
			String customerEmail2 = scanner.nextLine();
			customerService.deleteCustomerByEmail(customerEmail2);
			break;
		case 8:
			System.out.println("Enter Product Id : ");
			int productIdC = scanner.nextInt();
			customerService.deleteAllCustomersByProductId(productIdC);
			break;
		case 9:
			customerService.getAllCutomers();
			break;
		case 10:
			System.out.println("Enter Product Id : ");
			int productId = scanner.nextInt();
			System.out.println("Enter Product Name : ");
			scanner.nextLine();
			String productName = scanner.nextLine();
			System.out.println("Enter Product Brand : ");
			String productBrand = scanner.nextLine();
			System.out.println("Enter Product Price : ");
			int productPrice = scanner.nextInt();
			Product product = new Product();
			product.setProductId(productId);
			product.setProductName(productName);
			product.setProductBrand(productBrand);
			product.setProductPrice(productPrice);
			productService.addProduct(product);
			break;
		case 11:
			System.out.println("Enter Product Id : ");
			int productId1 = scanner.nextInt();
			productService.findProductById(productId1);
			break;
		case 12:
			System.out.println("Enter Product Price1 : ");
			int productPrice1 = scanner.nextInt();
			System.out.println("Enter Product Price2 : ");
			int productPrice2 = scanner.nextInt();
			productService.findProductBetweenPrice(productPrice1, productPrice2);
			break;
		case 13:
			System.out.println("Enter Customer Email Id : ");
			scanner.nextLine();
			String customerEmail3 = scanner.nextLine();
			productService.findAllProductByCustomerEmail(customerEmail3);
			break;
		case 14:
			System.out.println("Enter Price to increase per product : ");
			int productPrice3 = scanner.nextInt();
			System.out.println("Enter Brand Name : ");
			scanner.nextLine();
			String productBrand1 = scanner.nextLine();
			productService.updateAllProductPriceByProductBrand(productPrice3, productBrand1);
			break;
		case 15:
			System.out.println("Enter ProductId : ");
			int productId2 = scanner.nextInt();
			productService.deleteProductById(productId2);
			break;
		case 16:
			System.out.println("Enter BrandName : ");
			scanner.nextLine();
			String productBrand2 = scanner.nextLine();
			productService.deleteAllProductByBrand(productBrand2);
			break;
		case 17:
			System.out.println("Enter Customer Email Id : ");
			scanner.nextLine();
			String customerEmailId = scanner.nextLine();
			productService.deleteAllProductByCustomerEmail(customerEmailId);
			break;
		case 18:
			productService.getAllProducts();
			break;
		default:
			System.out.println("❤❤❤.......Please Enter Correct Input.......❤❤❤");
			break;
		}
	}
}
