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
    	System.out.println("Enter 2 to view data");
    	System.out.println("Enter 3 to Update Balance");
    	System.out.println("Enter 4 to Close Account");
    	int n=sc.nextInt();
    	switch(n) {
    	case 1:{
    		c.create();
    		break;
    	}
    	case 2:{
    		c.view();
    		break;
    	}
    	case 3:{
    		c.Update();
    		break;
    	}
    	case 4:{
    		c.close();
    		break;
    	}
    	default:System.out.println("Enter valid no");
    	}
    	
    }
}
