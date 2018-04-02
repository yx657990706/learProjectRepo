package com.beyond.eth.thread.service;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread {

	private CountDownLatch latch;//线程计数

	public MyThread() {
        
	}
	
	public MyThread(CountDownLatch latch) {
        this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("=====01====");
		try {
			Thread.sleep(2 * 1000);
			System.out.println("=====02====");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			latch.countDown();// 计数器减1
		}

	}

}
