package todoApp;

import static org.testng.Assert.assertEquals;

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
		deleteAllItem();
	}

	@Test 
	public void test01_creatItems()
	{
		assertEquals(getItemNumber(),3);
	}

	@Test 
	public void test02_filterCompleted()
	{
		toggleItem(2);
		filterCompleted();
		assertEquals(getItemNumber(),1);
	}

	@Test 
	public void test03_filterActive()
	{
		toggleItem(2);
		filterActive();
		assertEquals(getItemNumber(),2);
	}

	@Test 
	public void test04_clearComplete()
	{
		toggleItem(2);
		clearComplete();
		assertEquals(getItemNumber(),2);
	}
	
	@Test 
	public void test05_itemsLeft()
	{
	
		assertEquals(itemsLeft(),3);
	}
	
	@Test 
	public void test06_renameIteme()
	{
		renameIteme(2, "Avi ti gandon");
		assertEquals(getItemName(2),"Avi ti gandon");
	}
	
	@Test 
	public void test07_deleteIteme()
	{
		deleteItem(0);
		assertEquals(getItemNumber(),2);
	}
	
	
}

