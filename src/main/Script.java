package main;

import generics.Excel;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class Script implements AutoConst{
	
	public static void executeScript(WebDriver driver, String sheet){
		Logger l=Logger.getLogger("Script");
		
		int stepCount=Excel.getRowCount(SCRIPT_PATH, sheet);
		String x=SCRIPT_PATH;
		l.info("Total No of steps"+stepCount);
		for(int j=1;j<=stepCount;j++)
		{
			String desc=Excel.getCellValue(x, sheet, j, 0);
			String action=Excel.getCellValue(x, sheet, j, 1);
			String input1=Excel.getCellValue(x,sheet, j, 2);
			String input2=Excel.getCellValue(x, sheet, j, 3);
		
			l.info("Description:"+desc);
			Step.executeStep(driver, action, input1, input2);
			
		}
	}

}
