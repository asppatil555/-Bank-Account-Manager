package com.Bank.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Bank {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String bankName;
    
	
	@ManyToMany(mappedBy = "bank", cascade=CascadeType.ALL)
	private List<Accounts> account;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public List<Accounts> getAccount() {
		return account;
	}


	public void setAccount(List<Accounts> account) {
		this.account = account;
	}


	@Override
	public String toString() {
		return "Bank [id=" + id + ", bankName=" + bankName + ", account=" +  account.stream().map(Accounts::getId).toList() +"]";
	}
	
	
	
	

}
