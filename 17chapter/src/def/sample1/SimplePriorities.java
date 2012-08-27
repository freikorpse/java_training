package def.sample1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriorities implements Runnable {
	private int countDown = 5;
	private volatile double d; // No optimization
	private int priority;

	public SimplePriorities(int priority) {
		this.priority = priority;
	}

	public String toString() {
		return Thread.currentThread() + ": " + countDown;
	}

	public void run() {
		Thread.currentThread().setPriority(priority);
		while (true) {
			// An expensive, interruptable operation:
			for (int i = 1; i < 100000; i++) {
				d += (Math.PI + Math.E) / (double) i;
				if (i % 1000 == 0)
					Thread.yield();
			}
			System.out.println(this);
			--countDown;
			if (countDown == 0)
				return;
		}
	}

	public static void main(String[] args) {
		ExecutorService exec1 = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++)
			exec1.execute(new SimplePriorities(Thread.MIN_PRIORITY));
		exec1.shutdown();
		ExecutorService exec2 = Executors.newSingleThreadExecutor();
		exec2.execute(new SimplePriorities(Thread.MAX_PRIORITY));
		exec2.shutdown();
	}
}
