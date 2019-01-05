package concurrent_utilities;

public class CountDownLatchCustom {
	int count;
	
	//constructor
	CountDownLatchCustom(int count) {
		this.count = count;
	}
	
	//countDown method
	public synchronized void countDown() {
		count--;
		if(count == 0)
			this.notify();
	}
	
	//await method
	public synchronized void await() throws InterruptedException{
		while(count > 0)
			this.wait();
	}
}
