package com.Bank.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Bank.Entity.Accounts;
import com.Bank.Entity.Bank;
import com.Bank.Utility.HibernateUtility;

public class CrudOpe {
	
	Scanner sc=new Scanner(System.in);
	
	public void create() {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		Bank b=new Bank();
		Bank b1=new Bank();
		Accounts a=new Accounts();
		Accounts a1=new Accounts();
		Accounts a3=new Accounts();
		Accounts a4=new Accounts();
		Accounts a5=new Accounts();
		Accounts a6=new Accounts();
		List<Bank> banklist=Arrays.asList(b,b1);
		List<Bank> banklist2=Arrays.asList(b);
		List<Bank> banklist3=Arrays.asList(b1);
		
		List<Accounts> aclist=Arrays.asList(a,a1,a3,a4);
		List<Accounts> aclist2=Arrays.asList(a5,a6);
		
		System.out.println("Enter first bank name");
		String bname=sc.next();
		b.setBankName(bname);
		b.setAccount(aclist);
		
		System.out.println("Enter second bank name");
		String b2name=sc.next();
		b1.setBankName(b2name);
		
		System.out.println("Enter 1st acoount name holder name");
		String name=sc.next();
		a.setAccountHolder(name);
		System.out.println("Enter 1st account Type saving or current");
		String type=sc.next();
		a.setAccountType(type);
		System.out.println("Enter 1st account holder balance");
		double balance=sc.nextDouble();
		a.setBalance(balance);
		a.setBank(banklist2);
		
		System.out.println("Enter 2nd account holder name");
		String name1=sc.next();
		a1.setAccountHolder(name1);
		System.out.println("Enter 2nd account type ");
		String type1=sc.next();
		a1.setAccountType(type1);
		System.out.println("Enter 2nd Accound holder balance");
		Double balance1=sc.nextDouble();
		a1.setBalance(balance);
		a1.setBank(banklist2);
		
		System.out.println("Enter 3rd Account holder Name");
		String name2=sc.next();
		a3.setAccountHolder(name2);
		System.out.println("Enter 3rd Account holder type");
		String type2=sc.next();
		a3.setAccountType(type2);
		System.out.println("Enter 3rd Account holder balance");
		double balance2=sc.nextDouble();
		a3.setBalance(balance2);
		a3.setBank(banklist2);
		
		System.out.println("Enter 4th Account holder Name");
		String name3=sc.next();
		a4.setAccountHolder(name3);
		System.out.println("Enter 4th Account holder type");
		String type3=sc.next();
		a4.setAccountType(type3);
		System.out.println("Enter 4th Account holder balance");
		double balance3=sc.nextDouble();
		a4.setBalance(balance3);
		a4.setBank(banklist2);
		
		System.out.println("Enter 5th Account holder Name");
		String name4=sc.next();
		a5.setAccountHolder(name4);
		System.out.println("Enter 5th Account holder type");
		String type4=sc.next();
		a5.setAccountType(type4);
		System.out.println("Enter 5th Account holder balance");
		double balance4=sc.nextDouble();
		a5.setBalance(balance4);
		a5.setBank(banklist3);
		
		System.out.println("Enter 6th Account holder Name");
		String name5=sc.next();
		a6.setAccountHolder(name5);
		System.out.println("Enter 6th Account holder type");
		String type5=sc.next();
		a6.setAccountType(type5);
		System.out.println("Enter 6th Account holder balance");
		double balance5=sc.nextDouble();
		a6.setBalance(balance5);
		a6.setBank(banklist3);
		
		session.persist(b);
		session.persist(b1);
		session.persist(a);
		session.persist(a1);
		session.persist(a3);
		session.persist(a4);
		session.persist(a5);
		session.persist(a6);
		trans.commit();
		session.close();
		
	}
	
	public void viewAllBank() {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		List<Bank> b=session.createQuery("select a from Bank a", Bank.class).getResultList();
		b.stream().forEach(k->System.out.println(k));
		trans.commit();
		session.close();
	}
	
	public void viewAllAccounts() {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		List<Accounts> a=session.createQuery("select d from Accounts d", Accounts.class).getResultList();
		a.stream().forEach(k->System.out.println(k));
		trans.commit();
		session.close();
		
	}
	
	public void UpdateAccount() {
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
	
	
	public void UpdateBank() {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		System.out.println("Enter bank name to update");
		String bname=sc.next();
		Bank b=session.createQuery("select a from Bank a where bankName=:k", Bank.class).setParameter("k", bname).getSingleResult();
		System.out.println("Set bank name");
		String bank=sc.next();
		b.setBankName(bank);
		trans.commit();
		session.close();
		
	}
	
	public void DeleteBank() {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		System.out.println("Enter bank id to delete");
		int id=sc.nextInt();
		Bank b=session.find(Bank.class, id);
		session.remove(b);
		trans.commit();
		session.close();
	
	}
	
	
	public void DeleteAccount() {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		System.out.println("Enter Acoount holder name to close Account");
	    String name=sc.next();
		Accounts s=session.createQuery("select a from Accounts a where accountHolder=:k", Accounts.class).setParameter("k", name).getSingleResult();
		s.getAccountHolder();
		session.remove(s.getAccountHolder());
		trans.commit();
		session.close();
		
	}
	public void GetSingleBank() {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		System.out.println("Enter id to find details");
		int id=sc.nextInt();
		Bank b=session.find(Bank.class, id);
		System.out.println(b);
		trans.commit();
		session.close();
	
	}
	
	public void GetSingleAccount() {
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		System.out.println("Enter account holder name");
		String name=sc.next();
		Accounts a=session.createQuery("select s from Accounts s where accountHolder=:k ", Accounts.class).setParameter("k", name).getSingleResult();
		System.out.println(a);
		trans.commit();
		session.close();
		
		
	}

}
