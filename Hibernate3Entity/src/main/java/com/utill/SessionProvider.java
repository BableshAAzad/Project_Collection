package com.utill;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Cart;
import com.entity.Product;
import com.entity.User;

public class SessionProvider {
   public static Session getSession() {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Cart.class)
				.addAnnotatedClass(Product.class).addAnnotatedClass(User.class);
		SessionFactory factory = cfg.buildSessionFactory();
		return factory.openSession();
	}
}
