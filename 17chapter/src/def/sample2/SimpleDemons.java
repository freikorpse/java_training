package def.sample2;

import java.util.concurrent.TimeUnit;

public class SimpleDemons implements Runnable {

	private static int count = 0;
	private int id = count++;
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) {
		for (int i=0;i<6;i++){
			SimpleDemons item = new SimpleDemons();
			Thread daemon = new Thread (item, "tchort"+item.id);
			daemon.setDaemon(true);
			daemon.start();
		}
		try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		while(true){
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String name = Thread.currentThread().toString();
			System.out.println(name + " on fly ");
		}
	}

}
