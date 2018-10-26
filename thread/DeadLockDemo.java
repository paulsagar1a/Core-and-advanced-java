package thread;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Thread
 *******************************************************/

/* When two threads capture locks of two different resources 
 * and to complete each function one thread is trying to access another lock's resource
 * and other lock also trying the same; at that time dead lock occurs.
 * Imagine you are waiting for a call from your girlfriend with whom you had an argument. 
 * She too is waiting for you to call her and apologies. In other words, 
 * both of you are waiting for the other to call. Now if no one takes the 
 * phone and calls the other, you will never talk again. This is a deadlock.*/
public class DeadLockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String gf = "Anuradha";
		final String bf = "Srikant";
		
		Thread t1 = new Thread() {
			public void run() {
				synchronized(gf) {
					System.out.println(gf+" is expecting that her bf will call and say sorry to her.");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(bf) {
						System.out.println(bf+" calls and says he is sorry");
					}
				}
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
				synchronized(bf){
					System.out.println(bf+" is expecting that his gf will call and say sorry to him.");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(gf){
						System.out.println(gf+" calls and says she is sorry");
					}
				}
			}
		};
		
		t1.start();
		/*To overcome deadlock situation
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		t2.start();
	}

}
