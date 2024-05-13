package com;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.entity.Gadget;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a value : ");
		System.out.println("1: By default autowiring\n2: By no Autowiring\n3: ByType \n4: ByName\n5: by Constructor");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("AutowireDefault.xml"));
			Gadget gadget = (Gadget) beanFactory.getBean("gadget");
			System.out.println(gadget);
			break;
		case 2:
			BeanFactory beanFactory1 = new XmlBeanFactory(new FileSystemResource("AutowireNo.xml"));
			Gadget gadget1 = (Gadget) beanFactory1.getBean("gadget");
			System.out.println(gadget1.getLaptop());
			System.out.println(gadget1.getMobile());
			break;
		case 3:
			BeanFactory beanFactory2 = new XmlBeanFactory(new FileSystemResource("AutowireByType.xml"));
			Gadget gadget2 = (Gadget) beanFactory2.getBean("gadget");
			System.out.println(gadget2.getLaptop());
			System.out.println(gadget2.getMobile());
			break;

		case 4:
			BeanFactory beanFactory3 = new XmlBeanFactory(new FileSystemResource("AutowireByName.xml"));
			Gadget gadget3 = (Gadget) beanFactory3.getBean("gadget");
			System.out.println(gadget3.getLaptop());
			System.out.println(gadget3.getMobile());
			break;

		case 5:
			BeanFactory beanFactory4 = new XmlBeanFactory(new FileSystemResource("AutowireConstructor.xml"));
			Gadget gadget4 = (Gadget) beanFactory4.getBean("gadget");
			System.out.println(gadget4.getLaptop());
			System.out.println(gadget4.getLaptop1());
			System.out.println(gadget4.getMobile());
			System.out.println(gadget4.getMobile1());
			break;

		default:
			break;
		}
	}
}
