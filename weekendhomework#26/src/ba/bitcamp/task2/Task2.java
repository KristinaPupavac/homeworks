package ba.bitcamp.task2;

import java.util.Random;

public class Task2 {

	public static void main(String[] args) {

		Thread t1 = new Thread(new MyThread1());
		Thread t2 = new Thread(new MyThread2());
		Thread t3 = new Thread(new MyThread3());
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static class MyThread3 implements Runnable {

		@Override
		public void run() {
			Random random = new Random();
			for (int i = 0; i < 5; i++) {
				System.out.println(random.nextInt(5));
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

	public static class MyThread2 implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 4; i++) {
				System.out.println("BitCamp");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

	public static class MyThread1 implements Runnable {

		@Override
		public void run() {

			for (int i = 1; i < 11; i++) {
				System.out.println(i);

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
