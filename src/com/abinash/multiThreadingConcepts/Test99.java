package com.abinash.multiThreadingConcepts;

class Queue{
	int x ;
	boolean isDataPresent = false;

	synchronized void store(int j ) // according to rule of java for notify() and wait() we have to make the method synchronised .
	{
		try {
			if (isDataPresent == false) {
				x = j; // when data is not present it will store .
				System.out.println("Producers : " + x);
				isDataPresent = true; // once it is present it is our duty to make the variable as true.
				notify(); // Giving notification to the consumer that data is present .
			} else {
				wait();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	synchronized void retrieve() {
		try {
			if (isDataPresent == true) {
				System.out.println("Consumers: " + x);
				isDataPresent = false; // once consumed then it is our duty to make it false;
				notify(); // giving notification to producer that data is not present store something.
			} else {
				wait(); // silently you should wait .
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class Producer extends Thread {

	// the problem is we can't create the object of Queue class here then how can we
	// call the store method .
	// then there will be no reference of Queue. so how to call the Queue class
	// store method .
	// for that we can do it by using constructor and lets play with it .

	Queue a; // here q stores the address

	Producer(Queue q) {
		a = q; // a stores the address of q then a & q both points to the same object .
	}

	public void run() {
		int i = 1;
		for (;;) {
			a.store(i++);
		}
	}
}
 class Consumer extends Thread{
	
	 Queue b ;
	 Consumer(Queue q) {
		   q = b ;
	 }
	 
	public void run() {
		 for( ; ; ) {
			 b.retrieve(); // it will consume only the latest value only
		 }
	}
}

public class Test99 {
	
	public static void main(String[] args) {
		Queue q = new Queue(); // here q stores the address of the Queue object 
		Producer p = new Producer(q); // Producer()  particularly () means a call to the constructor . 
		Consumer c = new  Consumer(q);// this is thread type objects only as this class extends Thread
		p.start();
		c.start();
		
	}
}
