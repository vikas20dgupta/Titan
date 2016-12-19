package main;



import generics.InvalidActionException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Step {
	public static void executeStep(WebDriver driver,String action,String input1,String input2){
		
		if(action.equalsIgnoreCase("enter")){
			driver.findElement(By.xpath(input1)).sendKeys(input2);
		}
		else if(action.equalsIgnoreCase("click")){
			driver.findElement(By.xpath(input1)).click();}
		else if(action.equalsIgnoreCase("verifyElementPresent")){
			
			Action.verifyElementPresent(driver, input1);
		}
		else if(action.equalsIgnoreCase("verifyElementNotPresent")){
			
			Action.verifyElementNotPresent(driver, input1);
		}
		else{
			throw new InvalidActionException("invalid action:"+action);
		}
		
		
	
	}

}
