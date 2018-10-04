package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import com.nt.entity.Account;

public class CreateAccount {

	public static void main(String[] args) {
		
		Configuration conf = null;
		StandardServiceRegistryBuilder builder = null;
		ServiceRegistry registry = null;
		SessionFactory factory = null;
		Session session = null;
		Account account = null;
		Transaction tx = null;
		// bootstrap hibernate Activate hibernate framework
		conf = new Configuration();
		// load cfg file
		conf.configure("com/nt/config/Hibernate.cfg.xml");
		builder = new StandardServiceRegistryBuilder();
		builder.applySettings(conf.getProperties());
		registry = builder.build();
		// create SessionFactory obj
		factory = conf.buildSessionFactory(registry);
		// get session obj
		session = factory.openSession();
		// create domain class obj with data
		account = new Account();
		account.setAccNo(1000);
		account.setAccName("Devaj");
		account.setBalance(60000.0);
		// begin transaction
		tx = session.beginTransaction();
		session.save(account); // save obj insert the record
		tx.commit();
		System.out.println(account);
		// close obj
		session.close();
		factory.close();
	}// main
}// class
