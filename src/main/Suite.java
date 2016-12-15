package main;

import generics.Excel;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Suite {
	
	public static void executeSuite(){
		
		int passCount=0;
		int failCount=0;
		int skipCount=0;
		Logger l=Logger.getLogger("Suite");
		
		int scriptCount=Excel.getRowCount("./suite.xlsx","TestSet");
		l.info("ScriptCount:"+scriptCount);
		
		
		for(int i=1;i<=scriptCount;i++)
		{
			String scriptName=Excel.getCellValue("./suite.xlsx","TestSet", i, 0);
			String scriptStatus=Excel.getCellValue("./suite.xlsx","TestSet", i, 1);
			if(scriptStatus.equalsIgnoreCase("yes")){
				
				WebDriver driver=new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				driver.get("http://127.0.0.1:8082/orangehrm/symfony/web/index.php/auth/login");
				
				l.info("Executing the script:"+scriptName);
				try{
					Script.executeScript(driver,scriptName);
					l.info("End of the script:"+scriptName);
					passCount++;
					
				}
				catch(Exception e)
				{
					l.info("Script execution fail:"+e);
					failCount++;
				}
				
				l.info("End of the script:"+scriptName);
				driver.close();
			}
		
				else
				{
					
					l.info("Not executing the script:"+scriptName);
					skipCount++;
					}
			}//loop
		l.info("Total pass:"+passCount);
		l.info("Totla Fail:"+failCount);
		l.info("Total Skip:"+skipCount);
	}

}