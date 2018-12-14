package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;

public class SaveObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Employee emp=null;
		Transaction tx=null;
		boolean flag=false;
		//Bootstraping hibernate
		cfg=new Configuration();
		//Hold Hibernate Cfg file and Hibernate mapping file
		//cfg=cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		cfg=cfg.configure();
		//Build SessionFactory object
		/*factory=cfg.buildSessionFactory();
		System.out.println("SessionFactory object class name::"+factory.getClass());
		//create Session
		ses=factory.openSession();
		System.out.println("Session object class name::"+ses.getClass());
		//create Entiry class object
		emp=new Employee();
		emp.setEid(1067);
		emp.setEname("ramesh");
		emp.setSalary(9000);
		emp.setEmail("ramesh@gmail.com");
		//save object
		try {
			tx=ses.beginTransaction(); //begins Tx by calling con.setAutoCommit(false)
			System.out.println("Tx object class name::"+tx.getClass());
			  ses.save(emp);
			flag=true;
		}
		catch(HibernateException he) {
			  flag=false;
			  he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag==true) {
				tx.commit(); //commits Tx by calling con.commit()
				System.out.println("Object saved(Record inserted)");
			}
			else {
				tx.rollback(); //rollbacks Tx by calling con.rolloback()
				System.out.println("Object is not saved(Record not inserted)");
			}	
			//close objs
			 ses.close();
			 factory.close();
			}//finally */
				
		}//main
	}//class
