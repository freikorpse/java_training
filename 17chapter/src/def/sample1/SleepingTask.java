package def.sample1;

//: concurrency/SleepingTask.java
// Calling sleep() to pause for a while.
import java.util.concurrent.*;

public class SleepingTask extends LiftOff {
	public void run() {
		try {
			while (countDown-- > 0) {
				System.out.print(status());
				TimeUnit.SECONDS.sleep(1);
				if (getId()<4 && countDown==1){
					throw new InterruptedException();
				}
			}
		} catch (InterruptedException e) {
			System.err.println("Interrupted");
		}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
			exec.execute(new SleepingTask());
		exec.shutdown();
	}
}