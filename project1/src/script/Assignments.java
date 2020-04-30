package script;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import page.DynamicLoadPage;
import page.HoversPage;
import page.LoginPage;
import page.ModelPage;

public class Assignments {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	WebDriver driver;
	@BeforeMethod
	public void setup(){
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void ValidloginTest(){
		driver.get("http://the-internet.herokuapp.com/login");
		
		LoginPage lp=new LoginPage(driver);
		lp.login(driver,"tomsmith", "SuperSecretPassword!");
	}
	
	@Test(priority=1)
	public void invalidLoginTest(){
		driver.get("http://the-internet.herokuapp.com/login");
		
		LoginPage lp=new LoginPage(driver);
		try {
			lp.login(driver,"tomsmith", "abc!");
		} catch (Exception e) {
			Reporter.log("Login Failed.. Please verify User Credentials and Try again",true);
		}
	}
	
	@Test(priority=2)
	public void extractDynamicText(){
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		
		DynamicLoadPage dp= new DynamicLoadPage(driver);
		dp.extractText(driver);

	}
	
	
	@Test(priority=2)
	public void verifyModalWindTest() throws InterruptedException{
		driver.get("http://the-internet.herokuapp.com/entry_ad");
		
		ModelPage mp=new ModelPage(driver);
		mp.verify(driver);

	}
	@Test(priority=4)
	public void getUserNamesWithMouseHover(){
		driver.get("http://the-internet.herokuapp.com/hovers");
		
		HoversPage hp=new HoversPage(driver);
		hp.getUsers(driver);
	
	}
	@Test(priority=5)
	public void infiniteScroll() throws InterruptedException{
		driver.get("http://the-internet.herokuapp.com/infinite_scroll");
		Thread.sleep(5000);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		for(int i=0;i<5;i++){
			js.executeScript("window.scrollBy(0,500)");
			if(i==3){
				WebElement text = driver.findElement(By.xpath("(//div[@class='jscroll-added'])[1]"));
				js.executeScript("arguments[0].scrollIntoView(true);",text);
				String paragraph = text.getText();
				Reporter.log(paragraph,true);
			}
		}
		
	
	}
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}
