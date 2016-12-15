package main;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Driver {
	@Test
	
	public void main() {
		Logger l=Logger.getLogger("Driver");
		l.info("FrameWork Execution started");
		Suite.executeSuite();
		
		l.info("FrameWork Execution Ended");
		
			
		}//main
		
		}//class
	
		

	
