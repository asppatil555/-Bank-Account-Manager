package com.Bank.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")
public class Accounts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String accountHolder;
	private String accountType;
	private double balance;
	private LocalDate openesDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDate getOpenesDate() {
		return openesDate;
	}
	public void setOpenesDate(LocalDate openesDate) {
		this.openesDate = openesDate;
	}
	@Override
	public String toString() {
		return "Accounts [id=" + id + ", accountHolder=" + accountHolder + ", accountType=" + accountType + ", balance="
				+ balance + ", openesDate=" + openesDate + "]";
	}
	
	

}
