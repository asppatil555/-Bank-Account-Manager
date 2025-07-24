package com.Bank.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Bank.Entity.Accounts;
import com.Bank.Utility.HibernateUtility;

public class CrudOpe {
	
	Scanner sc=new Scanner(System.in);
	
	public void create() {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		Accounts a=new Accounts();
		System.out.println("Enter Account Holder Name");
		String acName=sc.next();
		a.setAccountHolder(acName);
		System.out.println("Enter which type of account");
		String actype=sc.next(); 
		a.setAccountType(actype);
		System.out.println("Set Balance");
		double balance=sc.nextDouble();
		a.setBalance(balance);
		System.out.println("Enter open date");
		String date=sc.next();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate acdate=LocalDate.parse(date, f);
		a.setOpenesDate(acdate);
		session.persist(a);
		trans.commit();
		session.close();
		
	}
	
	public void view() {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		System.out.println("Enter id to view All Data");
		int id=sc.nextInt();
		Accounts a=session.find(Accounts.class, id);
		System.out.println(a.toString());
		trans.commit();
		session.close();
	}
	
	public void Update() {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		System.out.println("Enter id To update Balance");
		int id=sc.nextInt();
		Accounts a=session.find(Accounts.class, id);
		System.out.println("Set Balance");
		double balance=sc.nextDouble();
		a.setBalance(balance);
		session.persist(a);
		trans.commit();
		session.close();
		
	}
	
	public void close() {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		System.out.println("Enter id to close Account");
		int id=sc.nextInt();
		Accounts s=session.find(Accounts.class, id);
		session.remove(s);
		trans.commit();
		session.close();
		
	}

}
