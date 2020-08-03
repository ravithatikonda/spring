package com.sun.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.sun.controller.MainController;
import com.sun.vo.EmployeeVO;

public class EmployeeDITest {

	public static void main(String[] args) {
		
		Scanner sc = null;
		String ename = null, eadd = null;
		float bsal = 0.0f, da = 0.0f, hra = 0.0f;
		int deduction=0;
		EmployeeVO vo = null;
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		MainController controller = null;
		String result = null;
		
		sc = new Scanner(System.in);
		System.out.println("enter Employee Name :: ");
		ename = sc.next();
		System.out.println("Enter Employee Addrs::");
		eadd = sc.next();
		System.out.println("Enter Basic_salary::");
		bsal = Float.parseFloat(sc.next());
		System.out.println("Enter DA::");
		da = Float.parseFloat(sc.next());
		System.out.println("Enter Hra ::");
		hra = Float.parseFloat(sc.next());
		System.out.println("Enter deduction ::");
		deduction=Integer.parseInt(sc.next());
		
		vo = new EmployeeVO();
		vo.setEname(ename);
		vo.setEadd(eadd);
		vo.setbSal(bsal);
		vo.setDa(da);
		vo.setHra(hra);
		vo.setDeduction(deduction);
		// create BEanFacory IOC container
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/sun/cfgs/applicationContext.xml");
		// get Controller Bean class object..
		controller = factory.getBean("controller", MainController.class);
		// invoke the method
		try {
			result = controller.processEmployee(vo);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Internal Problem");
			e.printStackTrace();
		}

	}

}
