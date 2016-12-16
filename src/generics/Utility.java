package generics;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	static Logger l=Logger.getLogger("Utility");
	public static void getScreenShot(WebDriver driver,String scriptName){
		
		SimpleDateFormat s=new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		String res=s.format(new Date());
		String imagepath=("./screenshots/"+scriptName+"_"+res+".png");
		
		TakesScreenshot t=(TakesScreenshot) driver;
		File srcFile = t.getScreenshotAs(OutputType.FILE);
		File destFile=new File(imagepath);
		try{
		FileUtils.copyFile(srcFile, destFile);
		
		}
		catch(Exception e)
		{
			
		}
		
		
	}

}
