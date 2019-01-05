package concurrent_utilities;

public class LatchDemo implements Runnable {
	
	CountDownLatchCustom latch;
	String threadName;
	long startTime;
	
	LatchDemo(CountDownLatchCustom latch, String threadName, long startTime) {
		this.latch = latch;
		this.threadName = threadName;
		this.startTime = startTime;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(startTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(threadName+" is up");
		latch.countDown();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatchCustom customLatch = new CountDownLatchCustom(3);
		Thread service1 = new Thread(new LatchDemo(customLatch, "Service-1", 5000));
		Thread service2 = new Thread(new LatchDemo(customLatch, "Service-2", 6000));
		Thread service3 = new Thread(new LatchDemo(customLatch, "Service-3", 7000));
		
		service1.start();
		service2.start();
		service3.start();
		
		try {
			customLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All services are ready.\nMain service is up.");
	}

}
