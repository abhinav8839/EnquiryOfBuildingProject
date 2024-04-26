package DriverSetup;

//Importing all the required packages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

//DriverSetup Class for returning the drivers to the main class;
public class DriverSetup {
	
	/*
	getWebDriver()-->A static method which gets browsername as an argument
	and return the suitable driver for the browser;
	*/
	public static WebDriver getWebDriver(String browserName)
	{
		if(browserName.equalsIgnoreCase("Chrome"))//For chrome;
		{
			return new ChromeDriver();//Returning Chrome driver;
		}
		else if(browserName.equalsIgnoreCase("Edge"))//For edge;
		{
			return new EdgeDriver();//Returning Edge Driver;
		}
		return null;//Returning null if browser name are not edge or chrome;
	}
}
