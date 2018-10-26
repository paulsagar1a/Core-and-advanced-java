package thread;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Thread
 *******************************************************/

/*Inter-thread communication or Co-operation is basically 
allowing synchronized threads to communicate to each others*/
public class InterThreadCommunication {
	public static class DoorOpeningSystem {
		public void ringDoorBell() throws InterruptedException {
			synchronized(this) {
				System.out.println("I have rung the door bell. And I am waiting outside.");
				this.wait();
				System.out.println("Finally I have entered inside the room.");
			}
		}
		public void openDoor() throws InterruptedException {
			Thread.sleep(5000);
			synchronized(this) {
				System.out.println("Door is opened.");
				this.notify();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoorOpeningSystem obj = new DoorOpeningSystem();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					obj.ringDoorBell();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				try {
					obj.openDoor();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		t1.start();
		t2.start();
	}

}
