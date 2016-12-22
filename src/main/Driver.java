package main;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Driver extends Thread{
 public String browser;
 public Driver(String browser){
	 this.browser=browser;
 }
	public void run(){
		Suite.executeSuite(browser);
	}
	
	
	public static void main(String[] args) {
		Logger l=Logger.getLogger("Driver");
		l.info("FrameWork Execution started");
		Driver d1=new Driver("firefox");
		d1.start();
		Driver d2=new Driver("chrome");
		d2.start();
		
		l.info("FrameWork Execution Ended");
		
			
		}//main
		
		}//class
	
		

	
