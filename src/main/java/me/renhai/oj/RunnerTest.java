package me.renhai.oj;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class RunnerTest {

	public static void main(String[] args) throws InterruptedException {
		
		int runnerNum = 10;
		final CountDownLatch begin = new CountDownLatch(1);
		final CountDownLatch end = new CountDownLatch(runnerNum);
		
		for (int i = 0; i < runnerNum; i++) {
			final int se = i;
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						begin.await();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					System.out.println("NO." + se + "start running");
					try {
						Thread.sleep(new Random().nextInt(10000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("NO." + se + "到达终点");
					end.countDown();
				}
				
			}).start();
		}
		
		
		System.out.println("start running");
		begin.countDown();
		
		end.await();
		System.out.println("比赛结束");
	}

}
