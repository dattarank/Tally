package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadPage {

//	private WebElement startBTN;
	private WebElement text;
//	public DynamicLoadPage(WebDriver driver){
//		startBTN=driver.findElement(By.xpath("//button"));
//	}
	
	@FindBy(xpath="//button")
	protected WebElement startBTN;
	
	public DynamicLoadPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void extractText(WebDriver driver){
		WebDriverWait wait=new WebDriverWait(driver, 10);
		startBTN.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
		text=driver.findElement(By.xpath("//h4[text()='Hello World!']"));
		if(text.isDisplayed()){
			System.out.println("Text is displayed as: "+text.getText());
		}else{
			System.out.println("Text is not displayed");
		}
	}
}
