package test.lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServerKeyboardThread implements Runnable{

	private Thread t;
	private String threadName;
	private BufferedReader reader;
	
	
	ServerKeyboardThread(String name){
		threadName = name;
	}
	
	
	public void run() {
		while(true) {
			try {
				reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println(reader.readLine());
			} catch (IOException e) {e.printStackTrace();}
		}
	}
	
	
	public void start () {
		if (t == null) {
			t = new Thread (this, threadName);
	        t.start ();
	    }
	}

}
