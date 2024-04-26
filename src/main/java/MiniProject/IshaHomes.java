package MiniProject;

//Importing all the required package;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.google.common.io.Files;
import Excel.ExcelUtility;
import Text.TextUtility;
import DriverSetup.DriverSetup;

//Automation base class;
public class IshaHomes{
	
    //Main Method;
	public static void main(String[] args) throws IOException, InvalidFormatException, InterruptedException {
		
		WebDriver driver;
		String outputToDocuments;
		TextUtility textWriter = new TextUtility();//Creating the Object to use the methods of class;
		ExcelUtility excelWriter = new ExcelUtility();//Creating the Object to use the methods of class;
		
		//Getting browser name as input from the user;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Browser Name (Chrome or Edge): ");
		String browserName = sc.nextLine();
		
		//Validating the browser name and setting up the right browse driver;
		while(true)
		{
			
			driver = DriverSetup.getWebDriver(browserName);
			if(driver==null)
			{
				System.out.println("Invalid Browser Name\nRe Enter The Browser Name (Chrome or Edge): ");
				browserName=sc.nextLine();//Getting Valid browser name as an input; 
				
				//Setting up the driver by DriverSetup class;
				driver = DriverSetup.getWebDriver(browserName);
			}
			else
			{
				break;
			}
		}
		
		//Maximizing the browser;
		driver.manage().window().maximize();
		
		//Adding implicit wait;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		//Getting the required URL;
		String MainUrl="https://ishahomes.com";
		driver.get(MainUrl);
		
		
		
		//Clicking on the Completed Project option;
		driver.findElement(By.xpath("//*[@id='menu-item-25810']")).click();
		
		Thread.sleep(2000);
		
		//Finding the div of completed projet;
		WebElement completedProjectcontainer = driver.findElement(By.xpath("//*[@id=\"boosted-tab-0\"]/div[1]/section/div/div"));
		Thread.sleep(2000);
		
		//Storing the webelements of completed project from the container ;
		List<WebElement> TotalProjectList = completedProjectcontainer.findElements(By.partialLinkText("Isha"));
		
		//Printing the Total Completed Project;
		System.out.println("The Total Number Of Completed Project By ISHA HOMES Is : " + TotalProjectList.size());
		
		//Appending the Output String to the outputToDocuments String;
		outputToDocuments = "The Total Number Of Completed Project By ISHA HOMES Is : " + TotalProjectList.size() + "\n";
		
		//Printing the First Five From the List
		int counter=1;//TO Break the loop on the Sixth iteration;
		for(WebElement project : TotalProjectList)
		{
			System.out.println(project.getText());//Printing First Five to console;
			outputToDocuments = outputToDocuments + project.getText() + "\n";//Appending the Output String to the outputToDocuments String;
			counter++;
			if(counter==6)
			{
				break;//Break
			}
		}
		
		//Clicking on Enquire Now;
		driver.findElement(By.partialLinkText("Enquire Now")).click();
		
		//Clicking on Vendor enquiry;
		driver.findElement(By.partialLinkText("Vendor Enquiry")).click();
		
		
		//Printing the Mail ID;
		String mailId = driver.findElement(By.partialLinkText("@ishahomes.com")).getText();
		System.out.println("Mail Id For Contacting ISHA HOMES : " + mailId);//Printing Mail Id of ISHA HOMES to console;
		outputToDocuments = outputToDocuments + "Mail Id For Contacting ISHA HOMES : " + mailId + "\n" ;//Appending the Output String to the outputToDocuments String;
		
		//ScreenShot of the Mail id page;
		File screenshotSource = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File screenshotLocation = new File("./src/Screenshots/Image.png");
		Files.copy(screenshotSource, screenshotLocation);
		
		//Adding output to the TEXT file;
		textWriter.writeOutput(outputToDocuments);
		
		////Adding output to the EXCEL file;
		excelWriter.writeOutput(outputToDocuments);
		
		//Closing the driver
		driver.quit();
		
		//Closing the scanner resource after using;
		sc.close();
	}
	
	

}


//Closing the Live Chat PopUp;
//driver.findElement(By.id("livchat_close")).click();
