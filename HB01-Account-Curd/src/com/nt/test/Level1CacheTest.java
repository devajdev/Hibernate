package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.nt.entity.Account;

public class Level1CacheTest {

	public static void main(String[] args) {
		
		Configuration conf=null;
		StandardServiceRegistryBuilder builder=null;
		ServiceRegistry registry=null;
		SessionFactory factory=null;
		Session session1=null;
		Session session2=null;
		Account acc1,acc2,acc3,acc4;
		//bootstrap configuration class
		conf=new Configuration();
		// load the cfg file
		conf.configure("com/nt/config/Hibernate.cfg.xml");
		// create builder class obj
		builder=new StandardServiceRegistryBuilder();
		builder.applySettings(conf.getProperties());
		//build the registry
		registry=builder.build();
		//create session factory obj
		factory=conf.buildSessionFactory(registry);
		session1=factory.openSession();
		session2=factory.openSession();
		
		acc1=(Account) session1.get(Account.class, 1000);
		acc2=(Account) session2.get(Account.class, 2000);
		
		acc3=(Account) session2.get(Account.class, 2000);
		acc4=(Account) session1.get(Account.class, 2000);
		acc1=(Account) session1.get(Account.class, 1000);
		
		//close
		session1.close();
		session2.close();
		factory.close();

	}//main
}//class
