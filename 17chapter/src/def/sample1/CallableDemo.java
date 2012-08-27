package def.sample1;

import java.util.concurrent.*;
import java.util.*;

class TaskWithResult implements Callable<String> {
	private int id;
	double ii = Math.random()+1;
	long i = (long) ii*1000;

	public TaskWithResult(int id) {
		this.id = id;
	}

	public String call() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(i);
		return "result of TaskWithResult " + id;
	}
}

class Reporter implements Runnable{
	private String ls = System.lineSeparator();
	
	ArrayList<Future<String>> results;
	
	Reporter (ArrayList<Future<String>> results){
		this.results = results;
	}

	@Override
	public void run() {
		int count = 0;
		long num=0;
		while (true){
			for (Future<String> fs : results){
				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("iter: "+num++);
				if (fs.isDone()){
					try {
						System.out.println(fs.get());
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
					count++;
				} else {
					System.out.println("not ready"+ls);
				}
				
				if (count>7){
					return;
				} 
			}
		}
	}
	
}

public class CallableDemo {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ExecutorService listner = Executors.newSingleThreadExecutor();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++)
			results.add(exec.submit(new TaskWithResult(i)));
		listner.execute(new Reporter(results));
		exec.shutdown();
		
		/*for (Future<String> fs : results)
			try {
				if (fs.isDone())
					System.out.println(fs.get());
			} catch (InterruptedException e) {
				System.out.println(e);
				return;
			} catch (ExecutionException e) {
				System.out.println(e);
			} finally {
				exec.shutdown();
			}*/
	}
}
