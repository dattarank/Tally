package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginPage {

	
		private WebElement unBox;
		private WebElement pwBox;
		private WebElement btn;
		public LoginPage(WebDriver driver) {
			unBox=driver.findElement(By.id("username"));
			pwBox=driver.findElement(By.name("password"));
			btn=driver.findElement(By.xpath("//button[@type='submit']"));
		}
		public void login(WebDriver driver,String un, String pw) {
			unBox.sendKeys(un);
			pwBox.sendKeys(pw);
			btn.click();
			WebDriverWait wait=new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flash success']")));
		
				WebElement HomePageOBJ = driver.findElement(By.xpath("//div[@class='flash success']"));
				if(HomePageOBJ.isDisplayed()){
					System.out.println("Login is Successful");
				}else{
					System.out.println("Login Failed");
				}
			
		}
	
}
