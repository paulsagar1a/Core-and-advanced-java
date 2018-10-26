package thread;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Array
 *******************************************************/
/*Live lock is a situation where two threads are doing their jobs but not able to progress*/
/*Imagine a situation where two threads are coming to through a narrow lane in the opposite 
directions. One thread is giving side to the others but at the same time the other thread 
also giving the same side to the first one. And again both do the same and this situation
is continuing. And no threads are making any progress. This is called Live lock.*/
public class LiveLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String side = "side";
		Thread t1 = new Thread() {
			@Override
			public void run() {
				//attempt to step aside for another thread
				while(side.equals(side)) {
					System.out.println("THREAD-1 waiting in the same side");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				//attempt to step aside for another thread
				while(side.equals(side)) {
					System.out.println("THREAD-2 waiting in the same side");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		t1.start();
		t2.start();
	}

}
