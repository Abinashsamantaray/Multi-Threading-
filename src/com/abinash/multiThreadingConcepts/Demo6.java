package com.abinash.multiThreadingConcepts;
 class Example extends Thread{
	@Override
	public void run() {
		System.out.println("printing chracters...");
		for(int i = 65 ; i<=95 ; i++) {
			System.out.println((char)i);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("chracter printing completed.");
	}
}
public class Demo6 {
	public static void main(String[] args) {
		System.out.println("main thread started and established connection.");
		Example e = new Example();
		e.start();
		try {
			e.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("main thread completed and closed its execution .");
		
		
	}
}
