package main;

import generics.Excel;
import generics.Utility;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Suite implements AutoConst{
	
	public static void executeSuite(String browser){
		
		int passCount=0;
		int failCount=0;
		int skipCount=0;
		ArrayList<String> failScript=new ArrayList<String>();
		ArrayList<String> passScript=new ArrayList<String>();
		Logger l=Logger.getLogger("Suite");
		
		int scriptCount=Excel.getRowCount(SUITE_PATH,TEST_SET);
		l.info("ScriptCount:"+scriptCount);
		
		
		for(int i=1;i<=scriptCount;i++)
		{
			String scriptName=Excel.getCellValue(SUITE_PATH,TEST_SET, i, 0);
			String scriptStatus=Excel.getCellValue(SUITE_PATH,TEST_SET, i, 1);
			if(scriptStatus.equalsIgnoreCase("yes")){
				WebDriver driver;
				if(browser.equalsIgnoreCase("firefox")){
					//System.setProperty(FIREFOX_KEY,FIREFOX_PATH);
					driver=new FirefoxDriver();
				}
				else
				{
					System.setProperty(CHROME_KEY,CHROME_PATH);
					driver=new ChromeDriver();
				}
				
				l.info("Browser is: "+browser);
				//WebDriver driver=new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				//driver.get("http://127.0.0.1:8082/orangehrm/symfony/web/index.php/auth/login");
			
				String url=Utility.getPropertyValue(SETTING_PATH, "URL");
				driver.get(url);
				l.info("Executing the script:"+scriptName);
				try{
					Script.executeScript(driver,scriptName);
					l.info("End of the script:"+scriptName);
					passCount++;
					passScript.add(scriptName);
					
				}
				catch(Exception e)
				{
					l.info("Script execution fail:"+e);
					failCount++;
					failScript.add(scriptName);
					Utility.getScreenShot(driver, scriptName);
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
		for(int j=1;j<=passCount;j++){
			l.info("Name of passed script="+passScript);
		}for(String name:failScript)
		{
			l.info("Name of failed Script="+name);
		}
		
	}

}
