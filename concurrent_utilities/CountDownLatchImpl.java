package concurrent_utilities;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchImpl implements Runnable{

	CountDownLatch latch;
	String threadName;
	long time;
	CountDownLatchImpl(CountDownLatch latch, String threadName, long time) {
		this.latch = latch;
		this.threadName = threadName;
		this.time = time;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println(threadName+" is activated");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch latch = new CountDownLatch(3);
		Thread t1 = new Thread(new CountDownLatchImpl(latch, "thread-1", 4000));
		Thread t2 = new Thread(new CountDownLatchImpl(latch, "thread-2", 2000));
		Thread t3 = new Thread(new CountDownLatchImpl(latch, "thread-3", 6000));
		t1.start();
		t2.start();
		t3.start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main thread is activated");
	}

}
