package def.sample1;

public class MainThread {
	public static void main(String[] args) {
		for (int i=0;i<5;i++){
			new Thread(new LiftOff(3)).start();
		}
	}
}
