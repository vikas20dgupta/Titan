package main;

import generics.Excel;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class Script {
	
	public static void executeScript(WebDriver driver, String sheet){
		Logger l=Logger.getLogger("Script");
		
		int stepCount=Excel.getRowCount("./scenario/script.xlsx", sheet);
		String x="./scenario/script.xlsx";
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
