package com.abinash.multiThreadingConcepts;

import java.util.Scanner;

// Here i will do addition , printing character , printing numbers
class Test extends Thread {
	
	public void run() {
		Thread t = Thread.currentThread();
		String name = t.getName();
		if(name.equals("ADD")) {
			addition();
		}
		else if(name.equals("CHAR")) {
			printChar();
		}
		else {
			printNums();
		}
			
	}
	
	public void addition() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first number");
		int a = sc.nextInt();
		System.out.println("Enter the second number");
		int b =sc.nextInt();
		System.out.println("the addition of A and B is  ");
		int c = a + b;
		System.out.println(c);
		System.out.println("Additon Ended ");
	}
	public void printChar() {
		System.out.println("Printing character started.... ");
		for(int i = 65 ; i<=75; i++) {
			System.out.println((char)i);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Printing character ended .... ");
	}
	public void printNums() {
		System.out.println("printing numbers started..... ");
		for(int i = 10 ; i<= 20 ; i++) {
			System.out.println(i);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("printing numbers ended.... ");
	}
}
	

public class Demo1 {
	public static void main(String[] args) throws Exception
		{
			Test t1 = new Test();
			Test t2 = new Test();
			Test t3 = new Test();
			
			t1.setName("ADD");// after creating thread objects assigning names to that... 
			t2.setName("CHAR");
			t3.setName("NUMS");
			
			t1.start();
			t2.start();
			t3.start();
		}
}
