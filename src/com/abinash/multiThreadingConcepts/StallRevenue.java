package com.abinash.multiThreadingConcepts;

import java.util.Scanner;

class Stall implements Runnable{

	private String stallName;
	private String details;
	private double stallArea;
	private double stallCost;
	private String owner ;
	
	public Stall() {
	}
	
	
	public Stall(String stallName, String details, double stallArea, String owner) {
		super();
		this.stallName = stallName;
		this.details = details;
		this.stallArea = stallArea;
		this.owner = owner;
	}
	
	public String getStallName() {
		return stallName;
	}


	public String getDetails() {
		return details;
	}


	public double getStallArea() {
		return stallArea;
	}


	public double getStallCost() {
		return stallCost;
	}


	public String getOwner() {
		return owner;
	}


	public void run() {
		stallCost = stallArea * 150;
	}
}

public class StallRevenue {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of stalls :");
		int n = sc.nextInt();
		sc.nextLine();
		
		Stall[] stalls = new Stall[n];
		
		for(int i = 0 ; i< n ; i++) {
			String s = sc.nextLine();
			String[] split = s.split(","); //  array of String it will convert the string into array and store the value with respective index and has refernce split
			stalls[i] = new Stall(split[0], split[1], Integer.parseInt(split[2]), split[3]);// in split[2] it is double in constructor so we have to user Wrapper class Integer.parseInt("it will take the string as input") , then int can implicitly convert into double . 
		}
		
		for(int i = 0 ; i<n ; i++) {
			 Thread t = new Thread(stalls[i]);
			 t.start();
			try {
				t.join();// main thread will the first to begin and it will  be the first thread to finish ,it will not wait for thread to execute . for that we have to use join 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		double totalCost = 0.0;
		
		for(int i = 0 ; i<n ; i++) {
			totalCost += stalls[i].getStallCost();
		}
		System.out.println("The total revenue is "+totalCost);
		
	}
}
