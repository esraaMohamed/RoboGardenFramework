package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	
	public int time = 50;

	Actions action;

	final WebDriverWait wait;

	BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		action = new Actions(driver);
		wait = new WebDriverWait(driver, time);
	}

	public void click(WebElement element) {
		element.click();
	}

	public void setText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void hover(WebElement element) {
		action.moveToElement(element).build().perform();
	}

	public void dragAndDropByLocation(WebElement element, int x, int y) {
		action.dragAndDropBy(element, x, y).build().perform();
	}

	public void dragAndDropByElement(WebElement draggable,WebElement droppable) {
		action.dragAndDrop(draggable,droppable).build().perform();
	}


	public void waitForVisibilityOf(final WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void clickByAction(WebElement element){
	    action.moveToElement(element).click().perform();
	}
	
	public void clickByJavaExecutor(WebElement element){
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", element);
	}

}