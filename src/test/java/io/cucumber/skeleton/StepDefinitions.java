package io.cucumber.skeleton;



import static org.junit.Assert.fail;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {
	
	private WebDriver driver;
	private String WIDGET = System.getenv("SEARCH_WIDGET_ID");
	private String SEARCH_BUTTON = System.getenv("SEARCH_BUTTON");
	
	
    @Given("I start at the LittleBird Online Shopping home page")
    public void I_Start_At_LittleBird() {
    	String SHOP = System.getenv("SHOP_PAGE");
    	System.setProperty("webdriver.chrome.silentOutput", "true");
    	Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(SHOP);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.name(WIDGET)));
        
    }
    
    @When("I search for {string}")
    public void i_search_for(String product) {
    	
        WebElement element = driver.findElement(By.name(WIDGET));
        WebElement elementSubmit = driver.findElement(By.className(SEARCH_BUTTON));
        element.sendKeys(product);
        elementSubmit.click();
    	WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(product)));
        WebElement element2 = driver.findElement(By.partialLinkText(product));
        element2.click();
        
    }
    
    @Then("I should find {string}")
    public void i_should_find(String result) {
        
        if(driver.getPageSource().contains(result))
        {
            
        }

        else
        {
            fail("Could not find product");
        }
    }

    @After
    public void Clean_Up() {
    	driver.quit();
    }

}

