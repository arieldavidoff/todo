package todoApp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class todosTest extends todosM


{
	@BeforeClass
	public void start()
	{



		System.setProperty("webdriver.chrome.driver","C:/Users/USER/Desktop/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		action= new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://todomvc.com/examples/react/#/");
	}

	@AfterClass
	public void close() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}


	@BeforeMethod
	public void before()
	{
		createItem( "AAA");
		createItem( "BBB");
		createItem( "CCC");
	

	}
	

	@AfterMethod
	public void after()
	{
		filterAll();
		//deleteAllItem();
	}

	@Test 
	public void test01_creatItems()
	{
		
	}



}
