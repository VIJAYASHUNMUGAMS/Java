package com.pkg.view;

class ThreadA extends Thread	 {
	
	public void run() {
		System.out.println("Method started");

		try {
			for (int i = 1; i <= 5; i++) {
				Thread.sleep(1000);
				System.out.println("i = " + i);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Method ended");
	}
}

public class ThreadClassOne {

	public static void main(String[] args) {
		System.out.println("Main started");
		ThreadA ta = new ThreadA();
		ta.start();
		System.out.println("Main ended");
	}
}