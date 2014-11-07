package net.viralpatel.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
	
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {

		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();

		EmployeeDetail employeeDetail = new EmployeeDetail("10th Street", "LA", "San Francisco", "U.S.");
		
		Employee employee = new Employee("Nina", "Mayers", new Date(121212), "114-857-965");
		employee.setEmployeeDetail(employeeDetail);
		employeeDetail.setEmployee(employee);
		
		
		session.save(employee);

		
		@SuppressWarnings("unchecked")
		List<Employee> employees = session.createQuery("from Employee").list();
		for (Employee employee1 : employees) {
			System.out.println(employee1.getFirstname() + " , "
					+ employee1.getLastname() + ", "
					+ employee1.getEmployeeDetail().getState());
		}

		session.getTransaction().commit();
		
		HibernateUtil.closeSession();
		
		
		
		logger.debug("aaaaaaa");
		logger.warn("bbbbb");
		logger.error("ccccc");
		logger.info("zzzzzz");
		
		System.exit(0);
	}
}
