package com.abinash.multiThreadingConcepts;

class Printer implements Runnable{
	@Override
	synchronized public void run() {
		 String name = Thread.currentThread().getName();
	
		 try {
			System.out.println(name +"Accessed the printer");
			Thread.sleep(3000);
			System.out.println(name+"is using the printer");
			Thread.sleep(4000);
			System.out.println(name+"finished using the printer.");
			Thread.sleep(5000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class Exmp implements Runnable
{
	public void run() {
		String name = Thread.currentThread().getName();
		try {
			System.out.println(name+"is executing the 1st line" );
			Thread.sleep(3000);
			System.out.println(name+"is executing the 2nd line" );
			Thread.sleep(3000);
			System.out.println(name+"is executing the 3rd line" );
			Thread.sleep(3000);
			synchronized (this) {
				System.out.println(name+"is executing the 4th line" );
				Thread.sleep(3000);
				System.out.println(name+"is executing the 5th line" );
				Thread.sleep(3000);
				
			}
			System.out.println(name+"is executing the 6th line" );
			Thread.sleep(3000);
			System.out.println(name+"is executing the 7th line" );
			Thread.sleep(3000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}




public class Demo7 {
	public static void main(String[] args) {
		Printer p = new Printer(); // job
		Exmp e1 = new Exmp();
		
		Thread t1 = new Thread(p); // worker
		Thread t2 = new Thread(p); // worker
		Thread t3 = new Thread(p);// workder
		
		t1.setName("BOY");
		t2.setName("GIRL");
		t3.setName("OTHER");
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
