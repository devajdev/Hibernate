package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.nt.entity.Account;

public class UdatingAccount {

	public static void main(String[] args) {

		Configuration conf = null;
		StandardServiceRegistryBuilder builder = null;
		ServiceRegistry registry = null;
		SessionFactory factory = null;
		Session session = null;
		Account acc = null;
		// load the bootstrap
		conf = new Configuration();
		// load the cfgs file
		conf.configure("com/nt/config/Hibernate.cfg.xml");
		// create builder obj
		builder = new StandardServiceRegistryBuilder();
		// apply setting
		builder.applySettings(conf.getProperties());
		// build registry
		registry = builder.build();
		// factory 
		factory = conf.buildSessionFactory(registry);
		// open session
		session = factory.openSession();
		acc = (Account) session.load(Account.class, 1000);
		System.out.println(acc);
		acc.setBalance(20000.0);
		Transaction tx=session.beginTransaction();
		session.update(acc);
		tx.commit();
		System.out.println("Account balance is updated "+acc.getBalance());
		// closing
		session.close();
		factory.close();
	}

}
