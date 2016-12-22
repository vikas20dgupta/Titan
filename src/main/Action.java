package main;


import generics.ElementNotPresentException;
import generics.ElementPresentException;
import generics.TitleMIsmatchException;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {
public static Logger l=Logger.getLogger("Action");
public static void verifyElementPresent(WebDriver driver,String input1){
	List<WebElement> elements = driver.findElements(By.xpath(input1));
	if(elements.size()>0){
		if(elements.get(0).isDisplayed()){
			l.info("Element is present and displayed");
		}
		else{
			String msg="Element is Not Displayed";
			throw new ElementNotPresentException(msg);
		}
	}
	else{
		String msg="Element is Not present";
		throw new ElementNotPresentException(msg);
	}
}

public static void verifyElementNotPresent(WebDriver driver,String input1){
	List<WebElement> elements = driver.findElements(By.xpath(input1));
	if(elements.size()>0){
		if(elements.get(0).isDisplayed()){
			String msg="Element is still present and displayed";
			throw new ElementPresentException(msg);
		}
		else{
			l.info("Element is not present");
		}
	}
	else{
		
		l.info("Element is not present");
	}
}
public static void verifyTitle(WebDriver driver,String input1){
	
	String expectedTitle=input1;
	WebDriverWait wait=new WebDriverWait(driver, 10);
	try{
		wait.until(ExpectedConditions.titleIs(expectedTitle));
		l.info("Title is mismatching");
	}
	catch(TimeoutException e){
		String aTitle=driver.getTitle();
		String msg="Title is not matching:Expected-->"+expectedTitle+"Actual Title"+aTitle;
				throw new TitleMIsmatchException(msg);
	}
}
}
