package com.abinash.multiThreadingConcepts;
class Demo10 extends Thread {
	@Override
	public void run() {
		for(int i = 1 ; i<=5 ; i++) {
			try {
			System.out.println("JAVA");
			Thread.sleep(10000);
			}catch(Exception e) {
				System.out.println("Some problem occured..");
			}
		}
	}
}



public class Test1 {
	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("main thread started execution.");
		Demo10 demo10 = new Demo10();
		demo10.start();
		demo10.join(); // it says that main stack thread you wait once demo10 thread completes its execution then we can procced your execution work .
		System.out.println("Main thread completed..");
		
	}
}
