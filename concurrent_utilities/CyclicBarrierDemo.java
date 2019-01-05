/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Concurrent Utilities
 *******************************************************/

package concurrent_utilities;

//Custom CyclicBarrier
public class CyclicBarrierDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclicBarrierCustom cyclicBarrier = new CyclicBarrierCustom(3, new CyclicBarrierEvent());
		
		Thread t1 = new Thread(new MyThread(cyclicBarrier, "Thread-1", 3000));
		Thread t2 = new Thread(new MyThread(cyclicBarrier, "Thread-2", 5000));
		Thread t3 = new Thread(new MyThread(cyclicBarrier, "Thread-3", 4000));
		
		t1.start();
		t2.start();
		t3.start();
		
		Thread t4 = new Thread(new MyThread(cyclicBarrier, "Thread-4", 1000));
		Thread t5 = new Thread(new MyThread(cyclicBarrier, "Thread-5", 3000));
		Thread t6 = new Thread(new MyThread(cyclicBarrier, "Thread-6", 2000));
		
		t4.start();
		t5.start();
		t6.start();
	}

}

class CyclicBarrierCustom {
	int initCount;
	int waitCount;
	Runnable cyclicBarrierEvent;
	
	public CyclicBarrierCustom(int count, Runnable cyclicBarrierEvent) {
		initCount = count;
		waitCount = count;
		this.cyclicBarrierEvent = cyclicBarrierEvent;
	}
	
	public synchronized void await() throws InterruptedException {
		waitCount--;
		if(waitCount > 0) {
			this.wait();
		} else {
			waitCount = initCount;
			this.notifyAll();
			cyclicBarrierEvent.run();
		}
	}
}

class CyclicBarrierEvent implements Runnable {
	@Override
	public void run() {
		System.out.println("CyclicBarrierEvent is up, as all thread execution is over");
	}
}

class MyThread implements Runnable {
	CyclicBarrierCustom cyclicBarrier;
	String threadName;
	long threadTime;
	
	public MyThread(CyclicBarrierCustom cyclicBarrier, String threadName, long threadTime) {
		this.cyclicBarrier = cyclicBarrier;
		this.threadName = threadName;
		this.threadTime = threadTime;
	}
	
	@Override
	public void run() {
		System.out.println(threadName+ " is waiting for other thread to reach common barrier point");
		try {
			Thread.sleep(threadTime);
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("As all threads have reached to the common barrier point "+threadName+" is now starts execution");
	}
}
