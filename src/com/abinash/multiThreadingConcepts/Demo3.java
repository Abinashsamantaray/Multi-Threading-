package com.abinash.multiThreadingConcepts;
class Test4 extends Thread{
	public void run() {
		System.out.println("typing started");
		for(int i = 0 ; i<=5 ;i++) {
			 System.out.println("Typing...");
			 try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("typing got completed.");
	} 	
}
class Test5 extends Thread{
	@Override
	public void run() {
		System.out.println("code completion started.");
		for(;;) // i have to make it a infinite loop this acitivity is dependent on user thread  typing
		{
			System.out.println("code completion...");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Test6 extends Thread{
	@Override
	public void run() {
		System.out.println("Auto saving started.");
		for(;;) {
			System.out.println("Auto saving going on ....");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Demo3 {
	public static void main(String[] args) {
		Test4 t4 = new Test4();
		t4.setName("TYPE");
		
		Test5 t5 = new Test5();
		t5.setName("COMPLETE");
		t5.setDaemon(true);
		
		Test6 t6 = new Test6();
		t6.setName("SAVE");
		t6.setDaemon(true);
		
		t4.start();
		t5.start();
		t6.start();
		
	}
}
