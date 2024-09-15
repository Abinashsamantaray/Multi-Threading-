package com.abinash.multiThreadingConcepts;

class Test2 extends Thread {
	@Override
	public void run() {
		System.out.println("user thread started exeution ");
		for(int i = 1; i <=5 ; i++) {
			System.out.println("user thread is executing");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("user thread ended execution ");
	}
}
class Test3 extends Thread{
	@Override
	public void run() {
		System.out.println("Daemon Thread started execution : ");
		for( ; ; ) {
			System.out.println("Daemon thread executing ...");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}
public class Demo2 {
	public static void main(String[] args) {
		System.out.println("main thread started execution ");
		Test2 t2 = new Test2();
		t2.start();
		
		Test3 t3 = new Test3();
		t3.setDaemon(true); // this method must be invoked before the start().
		t3.start();
		
		System.out.println("main thread finished  execution ");
	}
}
