package com.abinash.multiThreadingConcepts;
// By using single run() 
	class Test8 extends Thread{
		public void run() {
			Thread ct = Thread.currentThread();
			String name = ct.getName();
			
			if(name.equals("TYPE"))
			{
				codeTyping();
			}
			else if(name.equals("COMPLETE")) {
				codeCompleting();
			}
			else {
				autoSaving();
			}
		} 
		public void codeTyping() {
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
		public void codeCompleting() {

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
		public void autoSaving() {

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

	public class Demo4 {
		public static void main(String[] args) {
			Test8 t4 = new Test8();
			t4.setName("TYPE");
			
			Test8 t5 = new Test8();
			t5.setName("COMPLETE");
			t5.setDaemon(true);
			
			Test8 t6 = new Test8();
			t6.setName("SAVE");
			t6.setDaemon(true);
			
			t4.start();
			t5.start();
			t6.start();
			
		}
	}


