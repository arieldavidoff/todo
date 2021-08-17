package todoApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class todosM 

{
	protected WebDriver driver;
	protected Actions action;

	public void createItem(String name)
	{
		driver.findElement(By.className("new-todo")).sendKeys(name);
		driver.findElement(By.className("new-todo")).sendKeys(Keys.RETURN);
	}

	public void filterAll()
	{
		driver.findElement(By.linkText("All")).click();
	}

	public List<WebElement> listItems()
	{
		return driver.findElements(By.xpath("//ul[@class='todo-list']/li"));
	}

	public void deleteItem(int index)
	{
		WebElement ItemsDeleteX = driver.findElement(By.tagName("button"));
		action.moveToElement(listItems().get(index)).moveToElement(ItemsDeleteX).click().build().perform();;
	}

	public int getItemNumber()
	{
		return listItems().size();
	}

	public void deleteAllItem()
	{
		int count=getItemNumber();
		for(int i = 0;i < count;i++)
		{
			deleteItem(0);
		}
	}

	public void toggleItem(int index)
	{
		listItems().get(index).findElement(By.className("toggle")).click();
	}

	public void filterCompleted()
	{
		driver.findElement(By.linkText("Completed")).click();
	}

	public void filterActive()
	{
		driver.findElement(By.linkText("Active")).click();
	}

	public void clearComplete()
	{
		driver.findElement(By.className("clear-completed")).click();
	}

	public int itemsLeft()
	{
		return  Integer.parseInt(driver.findElement(By.xpath("//span[@class='todo-count']/strong")) .getText());
	}


	public String getItemName(int index)
	{
		return listItems().get(index).findElement(By.tagName("label")).getText();
	}

	public void renameIteme(int index,String newName)
	{
		int charCount = getItemName(index).length();
		WebElement itemName = listItems().get(index).findElement(By.tagName("label"));
		action.doubleClick(itemName).build().perform();


		for (int i = 0; i <=charCount ; i++)
		{
			listItems().get(index).findElement(By.className("edit")).sendKeys(Keys.BACK_SPACE);
		}
		listItems().get(index).findElement(By.className("edit")).sendKeys(newName);
		listItems().get(index).findElement(By.className("edit")).sendKeys(Keys.RETURN);


	}
}


