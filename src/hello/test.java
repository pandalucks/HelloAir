package hello;

import hello.air_eng.time_engine;
import hello.node.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hello World! " );
		time_engine te = time_engine.getInstance();

		for(int i=0; i < 3; i++) {
			
			try {
				Thread.sleep(1000);
				
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			nodeBase node = new nodeBase();
			te.registerNode(node);
			
			
		}
		
		te.startTimeEngine();

		
		System.out.println("-----------------");

	}

}
