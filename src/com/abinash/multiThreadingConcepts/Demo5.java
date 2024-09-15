package com.abinash.multiThreadingConcepts;

public class Demo5 {
	public static void main(String[] args) {
		try {
		 	System.out.println("Main thread started");
		 	System.out.println("main thread executing....");
		 	Thread.sleep(3000);
			System.out.println("main thread executing....");
			Thread.sleep(3000);
			System.out.println("main thread executing....");
			Thread.currentThread().interrupt();
			Thread.sleep(3000);
			System.out.println("main thread executing....");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Main thread completed ..");
	
		 	
	}
}
