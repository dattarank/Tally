package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModelPage {

	private WebElement modelObj;
	private WebElement closeObj;
	public ModelPage(WebDriver driver){
		closeObj=driver.findElement(By.xpath("//div/p[text()='Close']"));
	}
	
	public void verify(WebDriver driver) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='This is a modal window']")));
		modelObj=driver.findElement(By.xpath("//h3[text()='This is a modal window']"));
		if(modelObj.isDisplayed()){
			System.out.println("MODAL Window is displayed");
		}else{
			System.out.println("MODAL Window is not displayed");
		}
		Thread.sleep(3000);
		closeObj.click();
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='This is a modal window']")));
		modelObj=driver.findElement(By.xpath("//h3[text()='This is a modal window']"));
		if(modelObj.isDisplayed()){
			System.out.println("After the Refresh MODAL Window is displayed");
		}else{
			System.out.println("After the refresh MODAL Window is not displayed");
		}
	}
}
