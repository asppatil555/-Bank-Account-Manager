package com.Bank;

import java.util.Scanner;

import com.Bank.Repository.CrudOpe;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
    	CrudOpe c=new CrudOpe();
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter 1 to Create Account");
    	System.out.println("Enter 2 to view All Bank");
    	System.out.println("Enter 3 to view All Accounts");
    	System.out.println("Enter 4 to Update Accounts");
    	System.out.println("Enter 5 to update Bank");
    	System.out.println("Enter 6 to delete bank");
    	System.out.println("Enter 7 to delete Accounts");
    	System.out.println("Enter 8 to get single bank data");
    	int n=sc.nextInt();
    	switch(n) {
    	case 1:{
    		c.create();
    		break;
    	}
    	case 2:{
    		c.viewAllBank();
    		break;
    	}
    	case 3:{
    		c.viewAllAccounts();
    		break;
    	}
    	case 4:{
    		c.UpdateAccount();
    		break;
    	}
    	case 5:{
    		c.UpdateBank();
    		break;
    	}
    	case 6:{
    		c.DeleteBank();
    		break;
    	}
    	case 7:{
    		c.DeleteAccount();
    		break;
    	}
    	case 8:{
    		c.GetSingleBank();
    		break;
    	}
    	case 9:{
    		c.GetSingleAccount();
    		break;
    	}
    	default:System.out.println("Enter valid no");
    	}
    	
    }
}
