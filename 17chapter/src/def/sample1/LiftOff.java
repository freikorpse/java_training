package def.sample1;

public class LiftOff implements Runnable {
	protected int countDown = 10; // Default
	private static int taskCount = 0;
	private int id = taskCount++;
	private String ls = System.lineSeparator();
	
	protected int getId(){
		return id;
	}
	
	public LiftOff() {
		/*taskCount++;
		this.id=taskCount;*/
	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + " (" + (countDown > 0 ? countDown : "Liftoff!")
				+ ")"+ls;
	}

	public void run() {
		while (countDown > 0) {
			countDown--;
			System.out.print(status());
			Thread.yield();
		}
	}
}
