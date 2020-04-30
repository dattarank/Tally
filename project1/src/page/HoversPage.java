package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

public class HoversPage {

	private List<WebElement> avatar;
	private List<WebElement> users;
	public HoversPage(WebDriver driver){
		avatar=driver.findElements(By.xpath("//img[@alt='User Avatar']"));
		users=driver.findElements(By.xpath("//h5"));
	}
	
	public void getUsers(WebDriver driver){
		Actions act = new Actions(driver);
		for(WebElement av:avatar){
			act.moveToElement(av).perform();
			for(WebElement user:users){
				Reporter.log(user.getText(),true);
			}
			
		}
	}
}
